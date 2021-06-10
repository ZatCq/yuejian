package com.example.admin.yuejian_22.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.yuejian_22.Activity.RegistActivity;
import com.example.admin.yuejian_22.Base.BaseFragment;
import com.example.admin.yuejian_22.Bean.Login;
import com.example.admin.yuejian_22.Interf.RetrofitService;
import com.example.admin.yuejian_22.MainActivity;
import com.example.admin.yuejian_22.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;


/**
 * Created by lenovo on 2017/10/10.
 */

public class LoginFragment extends BaseFragment {
    private EditText getUsername;
    private  EditText getPassword;
    private Button loginbutton;
    private  Button registbutton;




    public LoginFragment() {
        // Required empty public constructor
    }


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//
//
//        // Inflate the layout for this fragment
//
//       // return inflater.inflate(R.layout.fragment_login, container, false);
//    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getUsername = (EditText) view.findViewById(R.id.username);
        getPassword = (EditText) view.findViewById(R.id.password);
        loginbutton = (Button) view.findViewById(R.id.loginbutton);
        registbutton = (Button) view.findViewById(R.id.registbutton);
        registbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),RegistActivity.class);
                startActivityForResult(intent,1);
            }
        });
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Retrofit retrofit = new Retrofit.Builder().baseUrl("http://60.205.189.39/").addConverterFactory(GsonConverterFactory.create()).build();
                RetrofitService service = retrofit.create(RetrofitService.class);
                String username = getUsername.getText().toString();
                String password = getPassword.getText().toString();
                Call<Login> call = service.userLogin(username, password);
                call.enqueue(new Callback<Login>() {
                    @Override
                    public void onResponse(Call<Login> call, Response<Login> response) {
                        Login login = response.body();
                        if (login.getUserid().equals("0")) {
                            Toast.makeText(getActivity(), "用户或密码错误", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(getActivity(), "登陆成功", Toast.LENGTH_SHORT).show();
                            MainActivity mainActivity =
                                    (MainActivity) getActivity();
                            if (mainActivity != null) {

                                mainActivity.replaceLoginFragment();
                                mainActivity.setSavedUserId(login.getUserid());//把值传过去，下次可以自动登陆。

                                setUserId(login.getUserid());
                            }
                        }

                    }

                    @Override
                    public void onFailure(Call<Login> call, Throwable t) {
                        Toast.makeText(getActivity(), "连网失败", Toast.LENGTH_SHORT).show();
                    }

                });

//            result233Call.enqueue(new Callback<Login>()


            }

        });
    }
    @Override
    //创建，先导布局
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                switch (resultCode) {
                    case RESULT_CANCELED:
                        break;
                    case RESULT_OK:
                        String username1 = data.getStringExtra("username");
                        getUsername.setText(username1);

                        break;

                }
                break;
            default:
                break;
        }
    }
}
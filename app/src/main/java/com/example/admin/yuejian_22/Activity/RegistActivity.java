package com.example.admin.yuejian_22.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.admin.yuejian_22.Interf.RetrofitService;
import com.example.admin.yuejian_22.MainActivity;
import com.example.admin.yuejian_22.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RegistActivity extends AppCompatActivity {

    private Button backbutton;
    private EditText username1;
    private EditText password1;
    private EditText tel;
    private EditText address1;
    private EditText intro;
    private Button regist;
    public RegistActivity(){


    }
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_regist);
//        backbutton = (Button) findViewById(R.id.backbutton1);
//        username1 = (EditText) findViewById(R.id.username);
//        password1 = (EditText) findViewById(R.id.password);
//        tel = (EditText) findViewById(R.id.number);
//        regist = (Button) findViewById(R.id.registbutton);
//        backbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(RegistActivity.this, MainActivity.class);
//                startActivityForResult(intent,1);
//            }
//        });
//        regist.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Retrofit retrofit = new Retrofit.Builder().baseUrl("http://60.205.189.39/").addConverterFactory(GsonConverterFactory.create()).build();
//                RetrofitService service = retrofit.create(RetrofitService.class);
//                String  username = username1.getText().toString();
//                String password = password1.getText().toString();
//                String mobilenum = tel.getText().toString();
//                Call<SimpleResult> call = service.userRegister(username,password,mobilenum);
//                call.enqueue(new Callback<SimpleResult>() {
//                    @Override
//                    public void onResponse(Call<SimpleResult> call, Response<SimpleResult> response) {
//                        SimpleResult simpelResult = response.body();
//                        if (simpelResult.getSuccess().equals("0")){
//                            Toast.makeText(RegistActivity.this,"注册失败",Toast.LENGTH_SHORT).show();
//                        }else {
//                            Toast.makeText(RegistActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
//                            String username = username1.getText().toString();
//                            Intent data = new Intent();
//                            data.putExtra("username",username);
//                            setResult(RESULT_OK,data);
//                            finish();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<SimpleResult> call, Throwable t) {
//
//                    }
//                });
//
//            }
//        });
//    }
}

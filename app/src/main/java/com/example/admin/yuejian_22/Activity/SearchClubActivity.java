package com.example.admin.yuejian_22.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.admin.yuejian_22.Base.BaseActivity;
import com.example.admin.yuejian_22.Fragment.ClubDFragment;
import com.example.admin.yuejian_22.R;

public class SearchClubActivity extends AppCompatActivity {
    private ImageButton back_club;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_club);

            back_club = (ImageButton) findViewById(R.id.back_club);
            back_club.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.print("1");
                    //Intent intent =new Intent(SearchClubActivity.this,ClubDFragment.class);

                    finish();
                }
            });



    }
}

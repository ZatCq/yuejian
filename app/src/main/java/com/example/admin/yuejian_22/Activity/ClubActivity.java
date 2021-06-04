package com.example.admin.yuejian_22.Activity;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


import com.example.admin.yuejian_22.Base.BaseActivity;
import com.example.admin.yuejian_22.R;

public class ClubActivity extends BaseActivity {
    private String club_name;
    private TextView club_name_detail;
    private String id;


    @Override
    public View onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_club);
        club_name_detail = (TextView) findViewById(R.id.club_name_detail);
        id = getIntent().getStringExtra("shop_id");
        club_name = getIntent().getStringExtra("club_name");
        club_name_detail.setText(club_name);
    }
}

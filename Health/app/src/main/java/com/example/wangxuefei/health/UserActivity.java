package com.example.wangxuefei.health;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by wangxuefei on 2015/11/25.
 */
public class UserActivity extends AppCompatActivity {

    ImageView person_center_img;
    Button user_signsdata;
    Button user_diagnoseinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        person_center_img=(ImageView)findViewById(R.id.person_center_img);
        user_signsdata=(Button)findViewById(R.id.user_signsdata);
        user_diagnoseinfo=(Button)findViewById(R.id.user_diagnoseinfo);

        person_center_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(UserActivity.this,PersonalCenterActivity.class);
                startActivity(intent);
            }
        });

        user_signsdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(UserActivity.this,SignsdataActivity.class);
                startActivity(intent);
            }
        });

        user_diagnoseinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(UserActivity.this,DiagnoseInfoActivity.class);
                startActivity(intent);
            }
        });



    }
}

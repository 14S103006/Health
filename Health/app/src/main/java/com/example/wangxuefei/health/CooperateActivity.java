package com.example.wangxuefei.health;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by wangxuefei on 2015/11/30.
 */
public class CooperateActivity extends AppCompatActivity {

    ImageView cooperate_back_img;
    ImageView cooperate_home_img;
    ImageView doctormain_me_img;

    Button chat_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cooperate);

        cooperate_back_img = (ImageView)findViewById(R.id.cooperate_back_img);
        cooperate_home_img = (ImageView)findViewById(R.id.cooperate_home_img);
        doctormain_me_img = (ImageView)findViewById(R.id.doctormain_me_img);
        chat_1 = (Button)findViewById(R.id.chat_1);

        cooperate_back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        cooperate_home_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CooperateActivity.this,DoctorMainActivity.class);
                startActivity(intent);
            }
        });

        doctormain_me_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CooperateActivity.this,DoctorCenterActivity.class);
                startActivity(intent);
            }
        });

        chat_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CooperateActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });

    }
}

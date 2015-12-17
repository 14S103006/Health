package com.example.wangxuefei.health;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by wangxuefei on 2015/11/25.
 */
public class PersonalCenterActivity extends AppCompatActivity {

    Button personal_setting;
    Button personcenter_feedback;
    Button personcenter_info;
    ImageView personcenter_home_img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_center);

        personal_setting=(Button)findViewById(R.id.personal_setting);
        personcenter_home_img=(ImageView)findViewById(R.id.personcenter_home_img);
        personcenter_feedback=(Button)findViewById(R.id.personcenter_feedback);
        personcenter_info=(Button)findViewById(R.id.personcenter_info);


        personal_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PersonalCenterActivity.this,SettingHelpActivty.class);
                startActivity(intent);
            }
        });

        personcenter_home_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        personcenter_feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PersonalCenterActivity.this,FeedbackActivity.class);
                startActivity(intent);
            }
        });

        personcenter_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PersonalCenterActivity.this,PersonalInfoActivity.class);
                startActivity(intent);
            }
        });

    }
}

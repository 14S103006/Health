package com.example.wangxuefei.health;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by wangxuefei on 2015/11/26.
 */
public class JudgediagActivity extends AppCompatActivity {

    ImageView judge_back_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_judgediag);
        judge_back_img=(ImageView)findViewById(R.id.judge_back_img);

        judge_back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

package com.example.wangxuefei.health;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by baokang on 2015/12/9.
 */
public class BasConditionActivity extends AppCompatActivity {

    ImageView bascondition_back_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_condition);

        bascondition_back_img = (ImageView)findViewById(R.id.bascondition_back_img);

        bascondition_back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

package com.example.wangxuefei.health;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by baokang on 2015/12/13.
 */
public class ChatActivity extends AppCompatActivity {

    ImageView chat_back_img;
    ImageView chat_add;
    RelativeLayout chat_line1,chat_line2,chat_line3,chat_line4;
    boolean isHidden=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        chat_back_img = (ImageView)findViewById(R.id.chat_back_img);
        chat_add = (ImageView)findViewById(R.id.chat_add);
        chat_line1 = (RelativeLayout)findViewById(R.id.chat_line1);
        chat_line2 = (RelativeLayout)findViewById(R.id.chat_line2);
        chat_line3 = (RelativeLayout)findViewById(R.id.chat_line3);
        chat_line4 = (RelativeLayout)findViewById(R.id.chat_line4);

        chat_back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        chat_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isHidden) {
                    //设置EditText文本为可见的
                    chat_line1.setVisibility(View.VISIBLE);
                    chat_line2.setVisibility(View.VISIBLE);
                    chat_line3.setVisibility(View.VISIBLE);
                    chat_line4.setVisibility(View.VISIBLE);
                } else {
                    //设置EditText文本为隐藏的
                    chat_line1.setVisibility(View.GONE);
                    chat_line2.setVisibility(View.GONE);
                    chat_line3.setVisibility(View.GONE);
                    chat_line4.setVisibility(View.GONE);
                }
                isHidden = !isHidden;
            }
        });
    }
}

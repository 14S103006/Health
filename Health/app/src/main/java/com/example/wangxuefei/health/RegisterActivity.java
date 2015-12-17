package com.example.wangxuefei.health;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by wangxuefei on 2015/11/25.
 */
public class RegisterActivity extends AppCompatActivity {

    TextView register_cancel_btn;
    TextView register_login_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register_cancel_btn=(TextView)findViewById(R.id.register_cancel_btn);
        register_login_btn=(TextView)findViewById(R.id.register_login_btn);

        register_cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

        register_login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}



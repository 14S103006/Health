package com.example.wangxuefei.health;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by wangxuefei on 2015/12/1.
 */
public class DoctorDiagActivity extends AppCompatActivity{

    ImageView doctordiag_back_img;
    Button doctordiag_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_diagnose);

        doctordiag_back_img = (ImageView)findViewById(R.id.doctordiag_back_img);
        doctordiag_add = (Button)findViewById(R.id.doctordiag_add);

        doctordiag_back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        doctordiag_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}

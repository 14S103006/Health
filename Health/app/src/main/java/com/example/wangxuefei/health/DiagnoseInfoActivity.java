package com.example.wangxuefei.health;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by wangxuefei on 2015/11/26.
 */
public class DiagnoseInfoActivity extends AppCompatActivity{
    ImageView diagnoseinfo_back_img;
    Button information;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_diagnoseinfo);

        diagnoseinfo_back_img=(ImageView)findViewById(R.id.diagnoseinfo_back_img);
        information=(Button)findViewById(R.id.information);

        diagnoseinfo_back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(DiagnoseInfoActivity.this,DetailDiagInfoActivity.class);
                startActivity(intent);
            }
        });


    }
}

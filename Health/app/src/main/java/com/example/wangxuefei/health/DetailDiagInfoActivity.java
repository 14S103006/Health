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
public class DetailDiagInfoActivity extends AppCompatActivity{

    ImageView detaildiaginfo_back_img;
    Button judge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detaildiaginfo);
        detaildiaginfo_back_img=(ImageView)findViewById(R.id.detaildiaginfo_back_img);
        judge=(Button)findViewById(R.id.judge);

        detaildiaginfo_back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        judge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(DetailDiagInfoActivity.this,JudgediagActivity.class);
                startActivity(intent);
            }
        });
    }
}

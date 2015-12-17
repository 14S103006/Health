package com.example.wangxuefei.health;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by wangxuefei on 2015/11/29.
 */
public class CreateCaseActivity extends AppCompatActivity{

    ImageView create_case_back;
    ImageView createcase_home_img;
    ImageView createcase_me_img;
    ImageView createcase_heart_img;
    ImageView doctorcase_addprocess;
    ImageView createcase_show;
    Button doctorcase_tag;
    Button doctorcase_info;
    Button doctorcase_diag;
    Button doctorcase_condition;
    private Bitmap bitmap;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createcase);

        create_case_back = (ImageView)findViewById(R.id.create_case_back);
        createcase_home_img = (ImageView)findViewById(R.id.createcase_home_img);
        createcase_me_img = (ImageView)findViewById(R.id.createcase_me_img);
        createcase_heart_img = (ImageView)findViewById(R.id.createcase_heart_img);
        doctorcase_tag = (Button)findViewById(R.id.doctorcase_tag);
        doctorcase_info = (Button)findViewById(R.id.doctorcase_info);
        doctorcase_diag = (Button)findViewById(R.id.doctorcase_diag);
        doctorcase_condition = (Button)findViewById(R.id.doctorcase_condition);
        doctorcase_addprocess = (ImageView)findViewById(R.id.doctorcase_addprocess);
        createcase_show = (ImageView)findViewById(R.id.createcase_show);

        Intent intent=getIntent();
        if(intent!=null)
        {
            bitmap=intent.getParcelableExtra("bitmap");
            createcase_show.setImageBitmap(bitmap);

        }
        create_case_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        createcase_home_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateCaseActivity.this,DoctorMainActivity.class);
                startActivity(intent);
            }
        });

        createcase_me_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateCaseActivity.this,DoctorCenterActivity.class);
                startActivity(intent);
            }
        });

        doctorcase_tag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateCaseActivity.this,TagActivity.class);
                startActivity(intent);
            }
        });

        doctorcase_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateCaseActivity.this,PatientInfoActivity.class);
                startActivity(intent);
            }
        });

        doctorcase_diag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateCaseActivity.this,DoctorDiagActivity.class);
                startActivity(intent);



            }
        });
        doctorcase_condition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });

        doctorcase_addprocess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* 显示Dialog */

                LayoutInflater lay = LayoutInflater.from(CreateCaseActivity.this);
                View view = lay.inflate(R.layout.activity_process, null);

                ImageView process_photo=(ImageView)view.findViewById(R.id.process_photo);

                dialog = new AlertDialog.Builder(CreateCaseActivity.this,R.style.Translucent_NoTitle).setView(view).create();
                process_photo.setOnClickListener(onClickListener);

                dialog.show();

                Window win = dialog.getWindow();
                win.getDecorView().setPadding(0,0,0,0);
                WindowManager.LayoutParams lp =win.getAttributes();
                lp.width = WindowManager.LayoutParams.FILL_PARENT;
                lp.height = WindowManager.LayoutParams.FILL_PARENT;
                win.setAttributes(lp);

                /* Dialog 点击 */


            }
        });




        createcase_heart_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateCaseActivity.this,CooperateActivity.class);
                startActivity(intent);
            }
        });
    }


    private final View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            dialog.dismiss();
            Log.i("测试", "王雪猪是傻猪！");
            Toast.makeText(CreateCaseActivity.this,"王雪猪是傻猪！",Toast.LENGTH_SHORT).show();
        }
    };
}

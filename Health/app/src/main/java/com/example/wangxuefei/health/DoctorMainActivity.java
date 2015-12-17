package com.example.wangxuefei.health;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

/**
 * Created by wangxuefei on 2015/11/29.
 */
public class DoctorMainActivity extends AppCompatActivity {

    Button create_case;
    ImageView doctormain_case_img;
    ImageView doctormain_heart_img;
    ImageView doctormain_personal;
    ImageView doctormain_takephoto;
    ImageView doctormain_showpicture;

    private static final String SHARENAME = "wangxuezhu";

    private static final String TAG = MainActivity.class.getName();
    private static final int GETPICTURE_CAMERA = 100;
    private String localTempImgFileName = null;
    private Bitmap bitpic = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctormain);

        create_case = (Button) findViewById(R.id.create_case);
        doctormain_case_img = (ImageView) findViewById(R.id.doctormain_case_img);
        doctormain_heart_img = (ImageView) findViewById(R.id.doctormain_heart_img);
        doctormain_personal = (ImageView) findViewById(R.id.doctormain_personal);
        doctormain_takephoto = (ImageView) findViewById(R.id.doctormain_takephoto);
        doctormain_showpicture = (ImageView) findViewById(R.id.doctormain_showpicture);


        create_case.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DoctorMainActivity.this, CreateCaseActivity.class);
                startActivity(intent);
            }
        });

        doctormain_case_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DoctorMainActivity.this, CreateCaseActivity.class);
                startActivity(intent);
            }
        });

        doctormain_heart_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DoctorMainActivity.this, CooperateActivity.class);
                startActivity(intent);
            }
        });

        doctormain_personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DoctorMainActivity.this, DoctorCenterActivity.class);
                startActivity(intent);
            }
        });

        doctormain_takephoto.setOnClickListener(onClickListener);
    }

    private final View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            String status = Environment.getExternalStorageState();
            if (status.equals(Environment.MEDIA_MOUNTED))//判断系统是否存在sd卡
            {
                try {
                    File dir = new File(Environment.getExternalStorageDirectory() + "/wangxuezhu/image");
                    if (!dir.exists()) {
                        dir.mkdirs();
                    }

                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    localTempImgFileName = "image_" + System.currentTimeMillis() + ".jpg";
                    File file = new File(dir, localTempImgFileName);

                    Log.d(TAG, file.getAbsolutePath());

                    savePhotoPath("photoPath", file.getAbsolutePath());

                    Uri uri = Uri.fromFile(file);
                    intent.putExtra(MediaStore.Images.Media.ORIENTATION, 0);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                    DoctorMainActivity.this.startActivityForResult(intent, GETPICTURE_CAMERA);

                } catch (ActivityNotFoundException e) {
                    // TODO Auto-generated catch block
                    Toast.makeText(DoctorMainActivity.this, "Do not find image path!", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(DoctorMainActivity.this, "Do not find sdcard!", Toast.LENGTH_LONG).show();
            }

        }

    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e(TAG, "==========onActivityResult========");
        Log.e(TAG, "GETPICTURE_CAMERA=" + GETPICTURE_CAMERA);
        Log.e(TAG, "RESULT_OK" + RESULT_OK);
        if (requestCode == GETPICTURE_CAMERA) {//若是拍照完毕返回
            if (resultCode == RESULT_OK) {
                String imagePath = getPhotoPath("photoPath");
                Log.e(TAG, "imagePath" + imagePath);
                if (bitpic != null) {
                    bitpic.recycle();
                }
                bitpic = BitmapFactory.decodeFile(imagePath);
                doctormain_showpicture.setImageBitmap(bitpic);
            }
        }

    }

    public void savePhotoPath(String key, String value) {
        SharedPreferences shared = getSharedPreferences(SHARENAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = shared.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public String getPhotoPath(String key) {
        SharedPreferences shared = getSharedPreferences(SHARENAME, MODE_PRIVATE);
        return shared.getString(key, null);
    }

}

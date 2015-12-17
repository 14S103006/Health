package com.example.wangxuefei.health;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.devspark.appmsg.AppMsg;

import org.apache.http.HttpResponse;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity{

    @Bind(R.id.login_username) EditText login_username;
    @Bind(R.id.login_password) EditText login_password;
    @Bind(R.id.login_radio_doctor) RadioButton login_radio_doctor;
    @Bind(R.id.isRemember) CheckBox isRemember;
    ImageView login_pwdseen;
    RequestQueue requestQueue;

    private String FILE = "Health";//用于保存SharedPreferences的文件
    private SharedPreferences shared = null;    //声明一个SharedPreferences


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        requestQueue=((HealthApp)getApplication()).getQueue();

        shared = getSharedPreferences(FILE, MODE_PRIVATE);
        rememberUserLoginInfo();
    }

    /**
     * 记住用户名密码
     */
    private void rememberUserLoginInfo() {

        boolean isMemory=shared.getBoolean("isMemory", false);
        if (isMemory){
            String username= shared.getString("username","");
            String password= shared.getString("password","");
            login_username.setText(username);
            login_password.setText(password);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * 登录逻辑处理
     */
    @OnClick(R.id.login_btn)
    public void loginClick(){

        if (login_username.getText().toString().equals("") || login_password.getText().toString().equals("") ){
            AppMsg.makeText(MainActivity.this,"用户名或者密码不能为空！",AppMsg.STYLE_ALERT).show();
            return;
        }



        Intent intent;
        if (login_radio_doctor.isChecked()){
            intent=new Intent(MainActivity.this,DoctorMainActivity.class);
        }else{
            intent=new Intent(MainActivity.this,UserActivity.class);
        }
        startActivity(intent);



        MainActivity.this.finish();

        /*   baokang
        SharedPreferences.Editor editor = shared.edit();
        editor.putBoolean("isMemory",true);
        editor.putString("username", login_username.getText().toString());
        editor.putString("password",login_password.getText().toString());
        editor.commit();
        */

        /*  feifei edit  */

        if (isRemember.isChecked()) {
            if (shared == null) {
                shared = getSharedPreferences(FILE, MODE_PRIVATE);
            }
            SharedPreferences.Editor editor = shared.edit();
            editor.putBoolean("isMemory", true);
            editor.putString("username", login_username.getText().toString());
            editor.putString("password",login_password.getText().toString());
            editor.commit();
        } else if (!isRemember.isChecked()) {
            if (shared == null) {
                shared = getSharedPreferences(FILE, MODE_PRIVATE);
            }
            SharedPreferences.Editor edit = shared.edit();
            edit.putBoolean("isMemory", false);
            edit.commit();
        }


        /*

        final int roletype;
        if (login_radio_doctor.isChecked()){
            roletype=2;
        }else {
            roletype=1;
        }
        StringRequest request = new StringRequest(
                Request.Method.POST,
                "http://192.168.1.98:8080/login",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String str) {  //收到成功应答后会触发这里
                        Intent intent;
                        if (roletype==1){
                            intent=new Intent(MainActivity.this,UserActivity.class);
                        }else{
                            intent=new Intent(MainActivity.this,DoctorMainActivity.class);
                        }
                        startActivity(intent);
                        MainActivity.this.finish();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) { //出现连接错误会触发这里
                        Log.e("TAG",volleyError.getMessage(),volleyError);
                        AppMsg.makeText(MainActivity.this,"验证失败,用户名或者密码错误！",AppMsg.STYLE_ALERT).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {  //设置参数
                Map<String, String> map = new HashMap<String, String>();
                map.put("username", login_username.getText().toString());
                map.put("password", login_password.getText().toString());
                map.put("roletype", roletype+"");
                return map;
            }
        };
        requestQueue.add(request);

        */
    }

    /* 注册处理 */
    @OnClick(R.id.login_register_btn)
    public void registerClick(){
        Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
        startActivity(intent);
    }

    boolean isHidden=true;
    @OnClick(R.id.login_pwdseen)
    public void pwdClick(){
        if (!isHidden) {
            //设置EditText文本为可见的
            login_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            //设置EditText文本为隐藏的
            login_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        isHidden = !isHidden;
        login_password.postInvalidate();
        //切换后将EditText光标置于末尾
        CharSequence charSequence = login_password.getText();
        if (charSequence instanceof Spannable) {
            Spannable spanText = (Spannable) charSequence;
            Selection.setSelection(spanText, charSequence.length());
        }
    }


}

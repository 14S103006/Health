package com.example.wangxuefei.health;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.wangxuefei.health.Bean.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wangxuefei on 2015/12/18.
 */
public class SendMessageActivity extends AppCompatActivity implements Response.Listener<String>,Response.ErrorListener {

    @Bind(R.id.spinner_persons) Spinner spinner_persons;
    @Bind(R.id.send_message_button) Button send_message_button;
    @Bind(R.id.message_content) EditText message_content;

    private static final String TAG=SendMessageActivity.class.getSimpleName();
    User appUser = null;
    RequestQueue requestQueue;

    private List<String> data_list;
    private ArrayAdapter<String> arr_adapter;

    private int userid ;
    private int targetuserid ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
        ButterKnife.bind(this);
        appUser=((HealthApp) getApplication()).getUser();
        requestQueue = ((HealthApp) getApplication()).getQueue();


        data_list = new ArrayList<String>();
        if (appUser != null) {
            userid=appUser.getId();
            if (appUser.getId() == 1) {
                data_list.add("baokang");
                targetuserid=2;
            } else {
                data_list.add("wangxuezhu");
                targetuserid=1;
            }
        }
        //适配器
        arr_adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data_list);
        //设置样式
        arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //加载适配器
        spinner_persons.setAdapter(arr_adapter);

    }

    @OnClick(R.id.send_message_button)
    public void sendMessageButtonClick(){
        StringRequest request = new StringRequest(
                Request.Method.POST,
                "http://192.168.1.98:8080/message/sendmessage",
                this,this
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {  //设置参数
                Map<String, String> map = new HashMap<String, String>();
                map.put("content", message_content.getText().toString());
                map.put("userid", userid+"");
                map.put("targetuserid",targetuserid+"");
                return map;
            }
        };
        requestQueue.add(request);
    }

    @Override
    public void onErrorResponse(VolleyError volleyError) {
        Log.e(TAG, volleyError.getMessage(), volleyError);
    }

    @Override
    public void onResponse(String str) {
        Log.d(TAG, str);
    }
}

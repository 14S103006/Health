package com.example.wangxuefei.health;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by wangxuefei on 2015/12/1.
 */
public class HealthApp extends Application{

    private RequestQueue queue;

    @Override
    public void onCreate() {
        super.onCreate();
        queue= Volley.newRequestQueue(getApplicationContext());

    }


    public RequestQueue getQueue() {
        return queue;
    }

}

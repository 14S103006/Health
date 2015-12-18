package com.example.wangxuefei.health;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.wangxuefei.health.Bean.User;

/**
 * Created by wangxuefei on 2015/12/1.
 */
public class HealthApp extends Application {

    private RequestQueue queue = null;


    private User user = null;

    @Override
    public void onCreate() {
        super.onCreate();
        user = new User();
        queue = Volley.newRequestQueue(getApplicationContext());
    }


    public RequestQueue getQueue() {
        return queue;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        if (user == null) return;
        if (this.user == null) {
            this.user = new User();
        }
        this.user.setId(user.getId());
        this.user.setLimittype(user.getLimittype());
        this.user.setPassword(user.getPassword());
        this.user.setUsername(user.getUsername());
        this.user.setRoletype(user.getRoletype());
    }

}

package com.example.wangxuefei.health.Bean;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by wangxuefei on 2015/12/18.
 */
public class User {
    public static final String TAG = User.class.getSimpleName();

    private int id;
    private String username;
    private String password;
    private int roletype;
    private int limittype;

    public User parseJson(JSONObject json){
        if (json == null) {
            Log.e(TAG, "parse reporter param is null");
            return null;
        }
        try{
            if (!json.isNull("id")) {
                id = json.getInt("id");
            }
            if (!json.isNull("username")) {
                username = json.getString("username");
            }
            if (!json.isNull("password")) {
                password = json.getString("password");
            }
            if (!json.isNull("roletype")) {
                roletype = json.getInt("roletype");
            }
            if (!json.isNull("limittype")) {
                limittype = json.getInt("limittype");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoletype() {
        return roletype;
    }

    public void setRoletype(int roletype) {
        this.roletype = roletype;
    }

    public int getLimittype() {
        return limittype;
    }

    public void setLimittype(int limittype) {
        this.limittype = limittype;
    }
}

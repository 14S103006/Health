package com.example.wangxuefei.health;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by baokang on 2015/12/9.
 */
public class CreateProcessActivity extends AppCompatActivity{

    ImageView create_process_datepicker;
    ImageView createprocess_back_img;
    DatePicker datepiker;
    EditText create_process_date;

    Spinner spinner;
    List<String> data_list;
    ArrayAdapter<String> arr_adapter;
    boolean isHidden=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_process);

        create_process_datepicker = (ImageView)findViewById(R.id.create_process_datepicker);
        datepiker = (DatePicker)findViewById(R.id.datepicker);
        createprocess_back_img = (ImageView)findViewById(R.id.createprocess_back_img);
        create_process_date = (EditText)findViewById(R.id.create_process_date);
        spinner = (Spinner) findViewById(R.id.spinner);

        //数据
        data_list = new ArrayList<String>();
        data_list.add("首诊");
        data_list.add("复诊");
        data_list.add("入院");
        data_list.add("出院");
        data_list.add("手术");
        data_list.add("影响");
        data_list.add("化验");
        data_list.add("体征");
        data_list.add("病历");
        data_list.add("处方医嘱");


        //适配器
        arr_adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data_list);
        //设置样式
        arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //加载适配器
        spinner.setAdapter(arr_adapter);

        //设置默认值
        spinner.setVisibility(View.VISIBLE);


        create_process_datepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (!isHidden) {
                    //设置EditText文本为可见的
                    datepiker.setVisibility(View.VISIBLE);
                } else {
                    //设置EditText文本为隐藏的
                    datepiker.setVisibility(View.GONE);
                }
                isHidden = !isHidden;

                //切换后将EditText光标置于末尾


            }
        });

        createprocess_back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}

package com.example.btl_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button BtnQLPhong;
    Button BtnQLTaiSan;
    Button BtnHienThiPhong;
    Button BtnHienThiTaiSan;

    DBHelperTaiSan mDBHlperTaiSan;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();


    }

    private void initData() {
    }

    private void initView() {
        BtnQLPhong = findViewById(R.id.BtnQLPhong);
        BtnQLTaiSan = findViewById(R.id.BtnQLTaiSan);
        BtnHienThiPhong = findViewById(R.id.BtnHienThiPhong);
        BtnHienThiTaiSan = findViewById(R.id.BtnHienThiTaiSan);

        BtnQLPhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),QuanLyPhongActivity.class));
            }
        });
        BtnQLTaiSan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),QuanLyTaiSanActivity.class));
            }
        });
        BtnHienThiPhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),HienThiPhongActivity.class));
            }
        });
        BtnHienThiTaiSan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),HienThiTaiSanActivity.class));
            }
        });


    }
}
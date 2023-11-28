package com.example.btl_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class HienThiTaiSanActivity extends AppCompatActivity {
    ListView hienthi;
    DBHelperTaiSan mDBHelperTaiSan;
    ArrayList<TaiSanModel> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hien_thi_tai_san);

        mDBHelperTaiSan = new DBHelperTaiSan(getApplicationContext());
        mList = new ArrayList<>() ;
        mList = mDBHelperTaiSan.getTaiSanHon10tr();
        hienthi = findViewById(R.id.lvHienThiTaiSan);
        TaiSanAdapter adapter = new TaiSanAdapter(this,R.layout.layout_taisan,mList);
        hienthi.setAdapter(adapter);
    }

}
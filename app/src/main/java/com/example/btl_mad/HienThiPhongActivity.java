package com.example.btl_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class HienThiPhongActivity extends AppCompatActivity {
    ListView lvTaiSan,lvPhong;
    DBHelperPhong mDBHlperPhong;
    PhongAdapter adapter;
    ArrayList<PhongModel> mListPhong;
    DBHelperTaiSan mDBHelperTaiSan;
    ArrayList<TaiSanModel> mList;
    int vitri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hien_thi_phong);
        lvTaiSan = findViewById(R.id.lvDanhsachTaiSan);
        lvPhong = findViewById(R.id.lvDanhsachphong);

        mDBHlperPhong = new DBHelperPhong(this);
        mListPhong = new ArrayList<>();
        mListPhong= mDBHlperPhong.getAllPhong();
        adapter = new PhongAdapter(getApplicationContext(),R.layout.layout_phong,mListPhong);
        lvPhong.setAdapter(adapter);

        lvPhong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                vitri=mListPhong.get(i).getID_Phong();
                mDBHelperTaiSan = new DBHelperTaiSan(getApplicationContext());
                mList = new ArrayList<>() ;
                mList = mDBHelperTaiSan.getTaiSanTheoId(vitri);
                TaiSanAdapter adapter = new TaiSanAdapter(getApplicationContext(),R.layout.layout_taisan,mList);
                lvTaiSan.setAdapter(adapter);
            }
        });

    }
}
package com.example.btl_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class QuanLyPhongActivity extends AppCompatActivity {
    DBHelperPhong mDBHlperPhong;
    PhongAdapter adapter;
    ArrayList<PhongModel> mList;
    ListView lvDanhSachPhong;


    Button btnThemPhong;
    Button btnSuaPhong;
    Button btnXoaPhong;
    EditText edTenPhong;
    EditText edMoTaPhong;
    EditText edIDPhong;


    int vitri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_phong);
        mDBHlperPhong = new DBHelperPhong(this);

        mList = new ArrayList<>();
        mList= mDBHlperPhong.getAllPhong();
        initview();

    }

    private void initview() {
        btnThemPhong = findViewById(R.id.btnThemPhong);
        btnSuaPhong = findViewById(R.id.btnSuaPhong);
        btnXoaPhong = findViewById(R.id.btnXoaPhong);
        edTenPhong = findViewById(R.id.edTenPhong);
        edIDPhong = findViewById(R.id.ed_idphong);
        edMoTaPhong = findViewById(R.id.edMoTaPhong);
        lvDanhSachPhong = findViewById(R.id.lv_phong);

        adapter = new PhongAdapter(getApplicationContext(),R.layout.layout_phong,mList);
        lvDanhSachPhong.setAdapter(adapter);

        btnThemPhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PhongModel phong = new PhongModel(edTenPhong.getText().toString().trim(),edMoTaPhong.getText().toString().trim());
                mDBHlperPhong.addPhong(phong);
                mList.add(phong);
                lammoi();
                Toast.makeText(QuanLyPhongActivity.this, "Đã thêm", Toast.LENGTH_SHORT).show();
            }
        });

        lvDanhSachPhong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edTenPhong.setText(mList.get(i).getTen_Phong().toString());
                edMoTaPhong.setText(mList.get(i).getMota_Phong().toString());
                edIDPhong.setText(mList.get(i).getID_Phong()+"");
                vitri=mList.get(i).getID_Phong();
            }
        });
        btnXoaPhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDBHlperPhong.deletePhong(vitri);
                lammoi();
                Toast.makeText(QuanLyPhongActivity.this, "Đã xóa", Toast.LENGTH_SHORT).show();
            }
        });

        btnSuaPhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PhongModel phongModel =  new PhongModel(edTenPhong.getText().toString(),edMoTaPhong.getText().toString());
                mDBHlperPhong.updatePhong(vitri,phongModel);
                lammoi();
                Toast.makeText(QuanLyPhongActivity.this, "Sửa phòng thành Công", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void lammoi(){
        mList = mDBHlperPhong.getAllPhong();
        adapter = new PhongAdapter(getApplicationContext(),R.layout.layout_phong,mList);
        lvDanhSachPhong.setAdapter(adapter);

    }
}
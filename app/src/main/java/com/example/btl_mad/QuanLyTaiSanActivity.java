package com.example.btl_mad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class QuanLyTaiSanActivity extends AppCompatActivity {
    PhongSpinnerAdapter phongSpinnerAdapter;
    DBHelperPhong mDBHlperPhong;


    TaiSanAdapter adapter;
    Spinner spinner;
    ListView hienthi;
    DBHelperTaiSan mDBHelperTaiSan;
    ArrayList<TaiSanModel> mList;
    EditText edTen,edLoai,edGiaTri;
    Button btnThem,btnSua,btnXoa;
    int diachido;
    int vitri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_tai_san);
        mDBHelperTaiSan = new DBHelperTaiSan(getApplicationContext());
        mList = new ArrayList<>() ;
        mList = mDBHelperTaiSan.getAllTaiSan();
        hienthi = findViewById(R.id.lvTaiSan);
        capnhat();

        spinner = findViewById(R.id.spiner);
        btnThem = findViewById(R.id.btnThem);
        btnSua= findViewById(R.id.btnSua);
        btnXoa= findViewById(R.id.btnXoa);
        edTen = findViewById(R.id.tvTen);
        edLoai = findViewById(R.id.tvLoai);
        edGiaTri = findViewById(R.id.tvGiaTri);

        mDBHlperPhong = new DBHelperPhong(this);

        List<PhongModel> mlistPhong = mDBHlperPhong.getAllPhong();
        phongSpinnerAdapter = new PhongSpinnerAdapter(this,R.layout.item_phong,mlistPhong);
        spinner.setAdapter(phongSpinnerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                diachido = mlistPhong.get(i).ID_Phong;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        hienthi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edTen.setText(mList.get(i).getTen_TaiSan().toString());
                edLoai.setText(mList.get(i).getLoai_TaiSan().toString());
                edGiaTri.setText(String.valueOf(mList.get(i).getGiaTri_TaiSan()));
                vitri = mList.get(i).getID_TaiSan();
                int vitritaisan = Integer.parseInt(mList.get(i).getViTri_TaiSan());
                int pos=0;
                for(PhongModel phong : mlistPhong){
                    pos++;
                    if(phong.ID_Phong == vitritaisan) {
                        break;
                    }
                }
                spinner.setSelection(pos-1);
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edTen.getText().toString().trim().length()!=0&&edLoai.getText().toString().trim().length()!=0&&edGiaTri.getText().toString().trim().length()!=0)
                {
                    TaiSanModel taiSanModel = new TaiSanModel(edTen.getText().toString(),edLoai.getText().toString(),diachido+"",Integer.parseInt(edGiaTri.getText().toString()));
                    mDBHelperTaiSan.updateTaiSan(vitri,taiSanModel);
                    capnhat();
                    Toast.makeText(QuanLyTaiSanActivity.this, "Đã sửa", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(QuanLyTaiSanActivity.this, "Chọn tài sản cần sửa", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(edTen.getText().toString().trim().length()!=0&&edLoai.getText().toString().trim().length()!=0&&edGiaTri.getText().toString().trim().length()!=0)
                {
                    TaiSanModel taiSanModel = new TaiSanModel(edTen.getText().toString(),edLoai.getText().toString(),diachido+"",Integer.parseInt(edGiaTri.getText().toString()));
                    mDBHelperTaiSan.addTaiSan(taiSanModel);
                    capnhat();
                    Toast.makeText(QuanLyTaiSanActivity.this, "Đã cập nhật", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(QuanLyTaiSanActivity.this, "Hãy nhập đủ thông tin tài sản", Toast.LENGTH_SHORT).show();
                }


            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edTen.getText().toString().trim().length()!=0&&edLoai.getText().toString().trim().length()!=0&&edGiaTri.getText().toString().trim().length()!=0)
                {
                    mDBHelperTaiSan.deleteTaiSan(vitri);
                    capnhat();
                    Toast.makeText(QuanLyTaiSanActivity.this, "Đã xóa", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(QuanLyTaiSanActivity.this, "Chọn tài sản cần xóa", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    void capnhat(){
        mList = mDBHelperTaiSan.getAllTaiSan();
        adapter = new TaiSanAdapter(this,R.layout.layout_taisan,mList);
        hienthi.setAdapter(adapter);
    }
}
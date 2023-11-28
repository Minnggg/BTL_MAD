package com.example.btl_mad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TaiSanAdapter extends BaseAdapter {
    Context context;
    int layout;
    ArrayList<TaiSanModel> mlist;
    public TaiSanAdapter(Context context, int layout, ArrayList<TaiSanModel> mlist) {
        this.context = context;
        this.layout = layout;
        this.mlist = mlist;
    }



    @Override
    public int getCount() {
        if(mlist!=null) return mlist.size();
        else return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.layout_taisan,null);

        TextView tvTenTaiSan = view.findViewById(R.id.tvTenTaiSan1);
        tvTenTaiSan.setText("Tên tài sản: "+mlist.get(i).getTen_TaiSan().toString());
        TextView tvLoaiTaiSan = view.findViewById(R.id.tvLoaiTaiSan1);
        tvLoaiTaiSan.setText("Loại tài sản: "+mlist.get(i).getLoai_TaiSan().toString());
        TextView tvViTriTaiSan = view.findViewById(R.id.tvViTriTaiSan1);
        tvViTriTaiSan.setText("Vị trí tài sản: "+mlist.get(i).getViTri_TaiSan().toString());
        TextView tvGiaTriTaiSan = view.findViewById(R.id.tvGiaTriTaiSan1);
        tvGiaTriTaiSan.setText("Giá trị tài sản: "+String.valueOf(mlist.get(i).getGiaTri_TaiSan()));
        return view;
    }
}

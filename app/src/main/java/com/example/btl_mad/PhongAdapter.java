package com.example.btl_mad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PhongAdapter extends BaseAdapter {
    Context context;
    int layout;
    ArrayList<PhongModel> mlist;

    public PhongAdapter(Context context, int layout, ArrayList<PhongModel> mlist) {
        this.context = context;
        this.layout = layout;
        this.mlist = mlist;
    }

    @Override
    public int getCount() {
        return mlist.size();
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
        view = inflater.inflate(R.layout.layout_phong,null);

        TextView tvTenPhong = view.findViewById(R.id.tvTenPhong);
        tvTenPhong.setText(mlist.get(i).getTen_Phong());
        TextView tvMotaPhong = view.findViewById(R.id.tvMoTaPhong);
        tvMotaPhong.setText(mlist.get(i).getMota_Phong());


        return view;
    }
}

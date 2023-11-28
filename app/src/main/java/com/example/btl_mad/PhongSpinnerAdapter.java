package com.example.btl_mad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PhongSpinnerAdapter extends ArrayAdapter<PhongModel> {
    public PhongSpinnerAdapter(@NonNull Context context, int resource, @NonNull List<PhongModel> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_phong,parent,false);

        TextView tvName = convertView.findViewById(R.id.it_phong);
        TextView tvid = convertView.findViewById(R.id.it_id);

        PhongModel phongModel = this.getItem(position);
        if(phongModel != null){
            tvName.setText(phongModel.getTen_Phong().toString());
            tvid.setText(phongModel.getID_Phong()+"");
        }
        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_phong,parent,false);

        TextView tvName = convertView.findViewById(R.id.it_phong);
        TextView tvid = convertView.findViewById(R.id.it_id);

        PhongModel phongModel = this.getItem(position);
        if(phongModel != null){
            tvName.setText(phongModel.getTen_Phong()+"");
            tvid.setText(phongModel.getID_Phong()+"");
        }
        return convertView;
    }
}

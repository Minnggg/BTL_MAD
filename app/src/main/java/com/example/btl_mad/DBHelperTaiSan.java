package com.example.btl_mad;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelperTaiSan extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "taisan.db";
    public static final int version = 1;
    public static final String TABLE_TaiSan = "TaiSan";
    public static final String ID_TaiSan = "id";
    public static final String Ten_TaiSan = "Ten";
    public static final String Loai_TaiSan = "LoaiTaiSan";
    public static final String ViTri_TaiSan  = "ViTri";
    public static final String GiaTri_TaiSan = "GiaTri";
    public DBHelperTaiSan(@Nullable Context context) {
        super(context, DATABASE_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlTaiSan = "CREATE TABLE "+TABLE_TaiSan+" ("
                +ID_TaiSan+"\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                +Ten_TaiSan+"\tTEXT NOT NULL,"
                +Loai_TaiSan+"\tTEXT NOT NULL,"
                +ViTri_TaiSan+"\tTEXT NOT NULL,"
                +GiaTri_TaiSan+"\tINTEGER NOT NULL)";
        sqLiteDatabase.execSQL(sqlTaiSan);

    }

    public boolean addTaiSan(TaiSanModel taiSanModel){
        if(taiSanModel !=null){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(Ten_TaiSan,taiSanModel.getTen_TaiSan());
            contentValues.put(Loai_TaiSan,taiSanModel.getLoai_TaiSan());
            contentValues.put(ViTri_TaiSan,taiSanModel.getViTri_TaiSan());
            contentValues.put(GiaTri_TaiSan,taiSanModel.getGiaTri_TaiSan());
            long response = db.insert(TABLE_TaiSan,null,contentValues);

            Log.d("TAG", "addTaiSan: "+"thanhcong");
            db.close();

            if(response >-1) return false;
            return true;
        }
        return false;
    }

    @SuppressLint("Range")
    public ArrayList<TaiSanModel> getTaiSanHon10tr(){
        ArrayList<TaiSanModel> res = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM "+TABLE_TaiSan;
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor!=null){
            while (cursor.moveToNext()){
                TaiSanModel taisanModel = new TaiSanModel(cursor.getString(cursor.getColumnIndex(Ten_TaiSan))
                        ,cursor.getString(cursor.getColumnIndex(Loai_TaiSan))
                        ,cursor.getString(cursor.getColumnIndex(ViTri_TaiSan))
                        ,cursor.getInt(cursor.getColumnIndex(GiaTri_TaiSan)));
                Log.d("TAG", "getTaiSanHon10tr: "+taisanModel.toString());
                if (taisanModel.GiaTri_TaiSan >=10000000) res.add(taisanModel);
            }
            Log.d("TAG", "getTaiSanHon10tr: "+res.size());
        }
        return res;
    }

    @SuppressLint("Range")
    public ArrayList<TaiSanModel> getAllTaiSan(){
        ArrayList<TaiSanModel> res = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM "+TABLE_TaiSan;
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor!=null){
            while (cursor.moveToNext()){
                TaiSanModel taisanModel = new TaiSanModel(cursor.getString(cursor.getColumnIndex(Ten_TaiSan))
                        ,cursor.getString(cursor.getColumnIndex(Loai_TaiSan))
                        ,cursor.getString(cursor.getColumnIndex(ViTri_TaiSan))
                        ,cursor.getInt(cursor.getColumnIndex(GiaTri_TaiSan)));
                taisanModel.setID_TaiSan(cursor.getInt(cursor.getColumnIndex(ID_TaiSan)));
                res.add(taisanModel);
            }
        }
        return res;
    }


    @SuppressLint("Range")
    public ArrayList<TaiSanModel> getTaiSanTheoId(int idPhong){
        ArrayList<TaiSanModel> res = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM "+TABLE_TaiSan;
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor!=null){
            while (cursor.moveToNext()){
                TaiSanModel taisanModel = new TaiSanModel(cursor.getString(cursor.getColumnIndex(Ten_TaiSan))
                        ,cursor.getString(cursor.getColumnIndex(Loai_TaiSan))
                        ,cursor.getString(cursor.getColumnIndex(ViTri_TaiSan))
                        ,cursor.getInt(cursor.getColumnIndex(GiaTri_TaiSan)));
                taisanModel.setID_TaiSan(cursor.getInt(cursor.getColumnIndex(ID_TaiSan)));
                if (Integer.parseInt(taisanModel.ViTri_TaiSan) == idPhong) res.add(taisanModel);
            }
        }
        return res;
    }


    public boolean updateTaiSan(int id, TaiSanModel taiSanModel){
        if(id>=0 && taiSanModel !=null){
            SQLiteDatabase db = getReadableDatabase();
            String whereClause = ID_TaiSan+" =?";
            String[] whereArs = {id+""};
            ContentValues contentValues = new ContentValues();
            contentValues.put(Ten_TaiSan,taiSanModel.getTen_TaiSan());
            contentValues.put(Loai_TaiSan,taiSanModel.getLoai_TaiSan());
            contentValues.put(ViTri_TaiSan,taiSanModel.getViTri_TaiSan());
            contentValues.put(GiaTri_TaiSan,taiSanModel.getGiaTri_TaiSan());
            db.update(TABLE_TaiSan,contentValues,whereClause,whereArs);
            return true;
        }
        return false;
    }


    public boolean deleteTaiSan(int id){
        if(id>=0){
            SQLiteDatabase db = this.getWritableDatabase();
            String whereClause = ID_TaiSan+" =?";
            String[] whereArs = {id+""};
            db.delete(TABLE_TaiSan,whereClause,whereArs);
            db.close();
            return true;
        }
        return false;
    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

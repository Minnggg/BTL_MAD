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

public class DBHelperPhong extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "phong.db";
    public static final int version = 1;
    public static final String TABLE_Phong = "QLPhong";

    public static final String ID_Phong = "id";
    public static final String Ten_Phong = "Ten";
    public static final String Mota_Phong = "MoTa";

    public DBHelperPhong(@Nullable Context context) {
        super(context, DATABASE_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlPhong = "CREATE TABLE "+TABLE_Phong+" ("
                +ID_Phong+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                +Ten_Phong+" TEXT NOT NULL,"
                +Mota_Phong+" TEXT NOT NULL)";


        sqLiteDatabase.execSQL(sqlPhong);
    }

    public boolean addPhong(PhongModel phong){
        if(phong !=null){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(Ten_Phong,phong.getTen_Phong());
            contentValues.put(Mota_Phong,phong.getMota_Phong());
            long response = db.insert(TABLE_Phong,null,contentValues);
            db.close();
            if(response >-1) return false;
            return true;
        }
        return false;
    }

    public boolean updatePhong(int id, PhongModel phongModel){
        if(id>=0 && phongModel !=null){
            SQLiteDatabase db = getReadableDatabase();
            String whereClause = ID_Phong+" =?";
            String[] whereArs = {id+""};
            ContentValues contentValues = new ContentValues();
            contentValues.put(Ten_Phong,phongModel.getTen_Phong());
            contentValues.put(Mota_Phong,phongModel.getMota_Phong());
            db.update(TABLE_Phong,contentValues,whereClause,whereArs);
            return true;
        }
        return false;
    }
    public boolean deletePhong(int idPhong){
        if(idPhong>=0){
            SQLiteDatabase db = this.getWritableDatabase();
            String whereClause = ID_Phong+" =?";
            String[] whereArs = {idPhong+""};
            db.delete(TABLE_Phong,whereClause,whereArs);
            db.close();
            return true;
        }
        return false;
    }


    @SuppressLint("Range")
    public ArrayList<PhongModel> getAllPhong(){
        ArrayList<PhongModel> res = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM "+TABLE_Phong;
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor!=null){
            while (cursor.moveToNext()){
                PhongModel phongModel = new PhongModel(cursor.getString(cursor.getColumnIndex(Ten_Phong)),cursor.getString(cursor.getColumnIndex(Mota_Phong)));
                phongModel.setID_Phong(cursor.getInt(cursor.getColumnIndex(ID_Phong)));
                res.add(phongModel);
            }
        }
        return res;
    }







    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

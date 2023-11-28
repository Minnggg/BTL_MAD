package com.example.btl_mad;

public class PhongModel {
     int ID_Phong;
     String Ten_Phong;
     String Mota_Phong;

    public PhongModel( String ten_Phong, String mota_Phong) {
        Ten_Phong = ten_Phong;
        Mota_Phong = mota_Phong;
    }

    public int getID_Phong() {
        return ID_Phong;
    }

    public void setID_Phong(int ID_Phong) {
        this.ID_Phong = ID_Phong;
    }

    public String getTen_Phong() {
        return Ten_Phong;
    }

    public void setTen_Phong(String ten_Phong) {
        Ten_Phong = ten_Phong;
    }

    public String getMota_Phong() {
        return Mota_Phong;
    }

    public void setMota_Phong(String mota_Phong) {
        Mota_Phong = mota_Phong;
    }
}

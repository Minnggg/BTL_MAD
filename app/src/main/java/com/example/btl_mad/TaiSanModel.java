package com.example.btl_mad;

public class TaiSanModel {
    int ID_TaiSan;
    String Ten_TaiSan ;
    String Loai_TaiSan ;
    String ViTri_TaiSan  ;
    int GiaTri_TaiSan ;

    public TaiSanModel( String ten_TaiSan, String loai_TaiSan, String viTri_TaiSan, int giaTri_TaiSan) {
        Ten_TaiSan = ten_TaiSan;
        Loai_TaiSan = loai_TaiSan;
        ViTri_TaiSan = viTri_TaiSan;
        GiaTri_TaiSan = giaTri_TaiSan;
    }

    public int getID_TaiSan() {
        return ID_TaiSan;
    }

    public void setID_TaiSan(int ID_TaiSan) {
        this.ID_TaiSan = ID_TaiSan;
    }

    public String getTen_TaiSan() {
        return Ten_TaiSan;
    }

    public void setTen_TaiSan(String ten_TaiSan) {
        Ten_TaiSan = ten_TaiSan;
    }

    public String getLoai_TaiSan() {
        return Loai_TaiSan;
    }

    public void setLoai_TaiSan(String loai_TaiSan) {
        Loai_TaiSan = loai_TaiSan;
    }

    public String getViTri_TaiSan() {
        return ViTri_TaiSan;
    }

    public void setViTri_TaiSan(String viTri_TaiSan) {
        ViTri_TaiSan = viTri_TaiSan;
    }

    public int getGiaTri_TaiSan() {
        return GiaTri_TaiSan;
    }

    public void setGiaTri_TaiSan(int giaTri_TaiSan) {
        GiaTri_TaiSan = giaTri_TaiSan;
    }

    @Override
    public String toString() {
        return "TaiSanModel{" +
                "ID_TaiSan=" + ID_TaiSan +
                ", Ten_TaiSan='" + Ten_TaiSan + '\'' +
                ", Loai_TaiSan='" + Loai_TaiSan + '\'' +
                ", ViTri_TaiSan='" + ViTri_TaiSan + '\'' +
                ", GiaTri_TaiSan=" + GiaTri_TaiSan +
                '}';
    }
}

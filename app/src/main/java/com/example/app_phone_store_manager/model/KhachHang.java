package com.example.app_phone_store_manager.model;

public class KhachHang extends NguoiDung {
    private String maKH;


    public static final String TB_NAME = "KhachHang";
    public static final String TB_COL_ID = "maKH";
    public static final String TB_COL_NAME = "hoTen";
    public static final String TB_COL_PHONE = "dienThoai";
    public static final String TB_COL_LOCALE = "diaChi";

    public KhachHang() {
        super();
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }



    public KhachHang(String hoTen, String dienThoai, String diaChi, String maKH) {
        super(hoTen, dienThoai, diaChi);
        this.maKH = maKH;
    }
}

package com.example.app_phone_store_manager.model;

public abstract class NguoiDung {
    private String hoTen;
    private String dienThoai;
    private String diaChi;

    public NguoiDung() {
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public NguoiDung(String hoTen, String dienThoai, String diaChi) {
        this.hoTen = hoTen;
        this.dienThoai = dienThoai;
        this.diaChi = diaChi;
    }
}

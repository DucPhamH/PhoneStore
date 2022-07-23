package com.example.app_phone_store_manager.model;

public class NhanVien extends NguoiDung  {
    private String maNV;
    private String namSinh;
    private String taiKhoan;
    private String matKhau;
    private byte[] hinhAnh;

    public static final String TB_NAME = "NhanVien";
    public static final String TB_COL_ID = "maNV";
    public static final String TB_COL_NAME = "hoTen";
    public static final String TB_COL_PHONE = "dienThoai";
    public static final String TB_COL_LOCATION = "diaChi";
    public static final String TB_COL_DATE = "namSinh";
    public static final String TB_COL_USER = "taiKhoan";
    public static final String TB_COL_PASS = "matKhau";
    public static final String TB_COL_IMAGE = "hinhAnh";

    public NhanVien() {
        super();
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }
    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public byte[] getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(byte[] hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public NhanVien(String hoTen, String dienThoai, String diaChi, String maNV, String namSinh, String taiKhoan, String matKhau, byte[] hinhAnh) {
        super(hoTen, dienThoai, diaChi);
        this.maNV = maNV;
        this.namSinh = namSinh;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.hinhAnh = hinhAnh;
    }
}

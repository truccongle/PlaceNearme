package com.example.truccongle.searchanything.Model;

import java.io.Serializable;

/**
 * Created by truccongle on 10/26/2017.
 */

public class DiaDiem  implements Serializable{
    public  int Ma;
    public   String Ten;
    public   String HinhAnh;
    public   String DiaChi;
    public   String ThoiGian;
    public   String SDT;
    public String DanhGia;
    public  String LatLng;
    public int IdLoaiDiaDiem;

    public DiaDiem(int ma, String ten, String hinhAnh, String diaChi, String thoiGian, String SDT, String danhGia, String latLng, int idLoaiDiaDiem) {
        Ma = ma;
        Ten = ten;
        HinhAnh = hinhAnh;
        DiaChi = diaChi;
        ThoiGian = thoiGian;
        this.SDT = SDT;
        DanhGia = danhGia;
        LatLng = latLng;
        IdLoaiDiaDiem = idLoaiDiaDiem;
    }

    public int getMa() {
        return Ma;
    }

    public void setMa(int ma) {
        Ma = ma;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        HinhAnh = hinhAnh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(String thoiGian) {
        ThoiGian = thoiGian;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDanhGia() {
        return DanhGia;
    }

    public void setDanhGia(String danhGia) {
        DanhGia = danhGia;
    }

    public String getLatLng() {
        return LatLng;
    }

    public void setLatLng(String latLng) {
        LatLng = latLng;
    }

    public int getIdLoaiDiaDiem() {
        return IdLoaiDiaDiem;
    }

    public void setIdLoaiDiaDiem(int idLoaiDiaDiem) {
        IdLoaiDiaDiem = idLoaiDiaDiem;
    }
}

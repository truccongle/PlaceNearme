package com.example.truccongle.searchanything.Model;

/**
 * Created by truccongle on 11/5/2017.
 */

public class LoaiDiaDiem {
    public int Id;
    public  String Loai;
    public  String Hinhanh;

    public LoaiDiaDiem(int id, String loai, String hinhanh) {
        Id = id;
        Loai = loai;
        Hinhanh = hinhanh;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getLoai() {
        return Loai;
    }

    public void setLoai(String loai) {
        Loai = loai;
    }

    public String getHinhanh() {
        return Hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        Hinhanh = hinhanh;
    }
}

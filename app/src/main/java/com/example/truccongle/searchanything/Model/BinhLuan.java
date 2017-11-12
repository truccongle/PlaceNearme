package com.example.truccongle.searchanything.Model;

/**
 * Created by truccongle on 11/6/2017.
 */

public class BinhLuan {
    public  int IdBinhLuan;
    public  int Ma;
    public  int Id;
    public  String BinhLuan;

    public BinhLuan(int idBinhLuan, int ma, int id, String binhLuan) {
        IdBinhLuan = idBinhLuan;
        Ma = ma;
        Id = id;
        BinhLuan = binhLuan;
    }

    public int getIdBinhLuan() {
        return IdBinhLuan;
    }

    public void setIdBinhLuan(int idBinhLuan) {
        IdBinhLuan = idBinhLuan;
    }

    public int getMa() {
        return Ma;
    }

    public void setMa(int ma) {
        Ma = ma;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getBinhLuan() {
        return BinhLuan;
    }

    public void setBinhLuan(String binhLuan) {
        BinhLuan = binhLuan;
    }
}

package com.example.truccongle.searchanything.Model;

/**
 * Created by truccongle on 10/26/2017.
 */

public class TaiKhoan {


    public   String Id;
    public   String Name;
    public   String Pass;
    public   String Email;

    public TaiKhoan(String id, String name, String pass, String email) {
        Id = id;
        Name = name;
        Pass = pass;
        Email = email;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}

package com.oldspace.starcraftnet.Model;

/**
 * Created by Anthony on 18/11/2017.
 */

public class Citizen {
    int id;
    String Name;
    String Password;
    String Fono;
    String st;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getFono() {
        return Fono;
    }

    public void setFono(String fono) {
        Fono = fono;
    }

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }
}

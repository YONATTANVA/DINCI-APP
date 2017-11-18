package com.oldspace.starcraftnet.Model;

/**
 * Created by Anthony on 18/11/2017.
 */

public class Citizen {

    int id;
    String name;
    String password;
    String fono;
    String st;

    public Citizen(int id, String name, String password, String fono, String st) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.fono = fono;
        this.st = st;
    }

    public Citizen() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFono() {
        return fono;
    }

    public void setFono(String fono) {
        this.fono = fono;
    }

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }
}

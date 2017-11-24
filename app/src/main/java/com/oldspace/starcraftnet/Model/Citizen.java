package com.oldspace.starcraftnet.Model;

/**
 * Created by Anthony on 18/11/2017.
 */

public class Citizen {

    int id;
    String name;
    String password;
    String dni;
    String st;

    public Citizen(int id, String name, String password, String dni, String st) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.dni = dni;
        this.st = st;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }
}

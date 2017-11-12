package com.oldspace.starcraftnet.pojos;

/**
 * Created by Administrador on 11/11/2017.
 */

public class Citizen {

    private int idCitizen;
    private String nameCitizen;
    private String passwordCitizen;
    private String phonenumberCitizen;
    private String statusCitizen;

    public Citizen(int idCitizen, String nameCitizen, String passwordCitizen, String phonenumberCitizen, String statusCitizen) {
        this.idCitizen = idCitizen;
        this.nameCitizen = nameCitizen;
        this.passwordCitizen = passwordCitizen;
        this.phonenumberCitizen = phonenumberCitizen;
        this.statusCitizen = statusCitizen;
    }

    public int getIdCitizen() {
        return idCitizen;
    }

    public void setIdCitizen(int idCitizen) {
        this.idCitizen = idCitizen;
    }

    public String getNameCitizen() {
        return nameCitizen;
    }

    public void setNameCitizen(String nameCitizen) {
        this.nameCitizen = nameCitizen;
    }

    public String getPasswordCitizen() {
        return passwordCitizen;
    }

    public void setPasswordCitizen(String passwordCitizen) {
        this.passwordCitizen = passwordCitizen;
    }

    public String getPhonenumberCitizen() {
        return phonenumberCitizen;
    }

    public void setPhonenumberCitizen(String phonenumberCitizen) {
        this.phonenumberCitizen = phonenumberCitizen;
    }

    public String getStatusCitizen() {
        return statusCitizen;
    }

    public void setStatusCitizen(String statusCitizen) {
        this.statusCitizen = statusCitizen;
    }
}

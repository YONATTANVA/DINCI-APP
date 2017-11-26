package com.oldspace.starcraftnet.model;

/**
 * Created by YonattanVisita on 18/11/2017.
 */

public class Incident {
    private String image;
    private String type;
    private String detail;
    private String place;
    private int idCitizen;

    public Incident(String image, String type, String detail, String place, int idCitizen) {
        this.image = image;
        this.type = type;
        this.detail = detail;
        this.place = place;
        this.idCitizen = idCitizen;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getIdCitizen() {
        return idCitizen;
    }

    public void setIdCitizen(int idCitizen) {
        this.idCitizen = idCitizen;
    }
}

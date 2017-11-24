package com.oldspace.starcraftnet.model;

/**
 * Created by YonattanVisita on 18/11/2017.
 */

public class Incident {
    private String image;
    private String name;
    private String time;
    private String solution;

    public Incident(String image, String name, String time, String solution) {
        this.image = image;
        this.name = name;
        this.time = time;
        this.solution = solution;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }
}

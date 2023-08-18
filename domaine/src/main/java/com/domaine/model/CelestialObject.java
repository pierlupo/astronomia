package com.domaine.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CelestialObject {

    private int id;

    private String name;

    private String type;

    private Date date;

    private List<Comment> comments;

    public CelestialObject(String name, String type, Date date, List<Comment> comments) {
        this.name = name;
        this.type = type;
        this.date = date;
        this.comments = comments;
    }

    public CelestialObject(String name, String type, Date date) {
        this.name = name;
        this.type = type;
        this.date = date;
        comments = new ArrayList<>();
    }

    public CelestialObject(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public CelestialObject() {

    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Date getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }


}

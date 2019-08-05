package gst.trainingcourse.lesson7_ex2_hieunt94.model;

import java.io.Serializable;

public class Author implements Serializable {
    private int id;
    private String name;
    private String biography;

    public Author(int id, String name, String biography) {
        this.id = id;
        this.name = name;
        this.biography = biography;
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

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}

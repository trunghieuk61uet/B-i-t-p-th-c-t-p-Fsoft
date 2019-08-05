package gst.trainingcourse.lesson7_ex2_hieunt94.model;

import java.io.Serializable;

public class Album implements Serializable {
    private int id;
    private String name;
    private int authorId;

    public Album(int id, String name, int authorId) {
        this.id = id;
        this.name = name;
        this.authorId = authorId;
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

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}

package gst.trainingcourse.lesson7_ex2_hieunt94.model;

import java.io.Serializable;

public class Song implements Serializable {
    private int id;
    private String name;
    private String duration;
    private String sizeKB;
    private int albumId;

    public Song(int id, String name, String duration, String sizeKB, int albumId) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.sizeKB = sizeKB;
        this.albumId = albumId;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSizeKB() {
        return sizeKB;
    }

    public void setSizeKB(String sizeKB) {
        this.sizeKB = sizeKB;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

}

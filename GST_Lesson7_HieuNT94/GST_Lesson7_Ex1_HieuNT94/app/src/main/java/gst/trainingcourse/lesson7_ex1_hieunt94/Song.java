package gst.trainingcourse.lesson7_ex1_hieunt94;

import java.io.Serializable;

public class Song implements Serializable {
    private final String name;
    private final String author;
    private final String duration;
    private final int sizeInKB;

    public Song(String name, String author, String duration, int sizeInKB) {
        this.name = name;
        this.author = author;
        this.duration = duration;
        this.sizeInKB = sizeInKB;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getDuration() {
        return duration;
    }

    public int getSizeInKB() {
        return sizeInKB;
    }
}

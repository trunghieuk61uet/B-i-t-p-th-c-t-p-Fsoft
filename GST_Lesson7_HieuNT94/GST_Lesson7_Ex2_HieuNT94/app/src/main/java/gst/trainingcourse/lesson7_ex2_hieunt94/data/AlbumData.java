package gst.trainingcourse.lesson7_ex2_hieunt94.data;

import java.util.ArrayList;
import java.util.List;

import gst.trainingcourse.lesson7_ex2_hieunt94.model.Album;

public class AlbumData {
    private static AlbumData instance;

    private List<Album> allAlbumList;

    public static AlbumData getInstance() {
        if(instance == null) {
            instance = new AlbumData();
        }
        return instance;
    }

    private AlbumData() {
        generateData();
    }

    public Album findAlbumById(int id) {
        for(Album album: allAlbumList) {
            if(album.getId() == id) {
                return album;
            }
        }
        return  null;
    }

    public ArrayList<Album> findAlbumByAuthorId(int authorId) {
        ArrayList<Album> result = new ArrayList<>();
        for(Album album: allAlbumList) {
            if(album.getAuthorId() == authorId) {
                result.add(album);
            }
        }
        return result;
    }

    public List<Album> getAllAlbumList() {
        return allAlbumList;
    }

    private void generateData() {
        allAlbumList = new ArrayList<>();
        allAlbumList.add(new Album(1, "Cross Me", 1));
        allAlbumList.add(new Album(2, "Sugar", 3));
    }

}

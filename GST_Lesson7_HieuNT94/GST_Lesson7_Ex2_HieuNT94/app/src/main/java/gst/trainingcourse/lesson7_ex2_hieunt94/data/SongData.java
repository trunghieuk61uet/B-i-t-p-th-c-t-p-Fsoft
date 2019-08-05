package gst.trainingcourse.lesson7_ex2_hieunt94.data;

import java.util.ArrayList;
import java.util.List;

import gst.trainingcourse.lesson7_ex2_hieunt94.model.Album;
import gst.trainingcourse.lesson7_ex2_hieunt94.model.Song;


public class SongData {

    private static SongData instance;

    private List<Song> allSongList;

    public static SongData getInstance() {
        if (instance == null) {
            instance = new SongData();
        }
        return instance;
    }

    private SongData() {
        generateData();
    }

    public ArrayList<Song> findSongByAlbumId(int albumId) {
        ArrayList<Song> result = new ArrayList<>();
        for (Song song : allSongList) {
            if (albumId == song.getAlbumId()) {
                result.add(song);
            }
        }
        return result;
    }

    public List<Song> getAllSongList() {
        return allSongList;
    }

    public ArrayList<Song> findSongByAuthorId(int authorId) {
        ArrayList<Song> result = new ArrayList<>();
        ArrayList<Album> albumList = AlbumData.getInstance().findAlbumByAuthorId(authorId);
        for (Album album : albumList) {
            ArrayList<Song> songList = findSongByAlbumId(album.getId());
            for (Song song : songList) {
                result.add(song);
            }
        }
        return result;
    }

    private void generateData() {
        allSongList = new ArrayList<>();
        allSongList.add(new Song(1, "Beautiful People", "3:00", "1000KB", 1));
        allSongList.add(new Song(2, "Take Me Back To London", "3:00", "1000KB", 1));
        allSongList.add(new Song(3, "Cross Me", "3:00", "1000KB", 1));
        allSongList.add(new Song(4, "Sugar", "3:00", "1000KB", 2));
        allSongList.add((new Song(5, "Senorita", "3:00","1000KB", 4)));
        allSongList.add(new Song(6, "Havana", "3:00", "1000KB", 5));
        allSongList.add(new Song(1, "Beautiful People", "3:00", "1000KB", 1));
        allSongList.add(new Song(2, "Take Me Back To London", "3:00", "1000KB", 1));
        allSongList.add(new Song(3, "Cross Me", "3:00", "1000KB", 1));
        allSongList.add(new Song(4, "Sugar", "3:00", "1000KB", 2));
        allSongList.add((new Song(5, "Senorita", "3:00","1000KB", 4)));
        allSongList.add(new Song(6, "Havana", "3:00", "1000KB", 5));
        allSongList.add(new Song(1, "Beautiful People", "3:00", "1000KB", 1));
        allSongList.add(new Song(2, "Take Me Back To London", "3:00", "1000KB", 1));
        allSongList.add(new Song(3, "Cross Me", "3:00", "1000KB", 1));
        allSongList.add(new Song(4, "Sugar", "3:00", "1000KB", 2));
        allSongList.add((new Song(5, "Senorita", "3:00","1000KB", 4)));
        allSongList.add(new Song(6, "Havana", "3:00", "1000KB", 5));
    }
}

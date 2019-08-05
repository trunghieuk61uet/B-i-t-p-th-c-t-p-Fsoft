package gst.trainingcourse.lesson7_ex2_hieunt94.data;

import java.util.ArrayList;
import java.util.List;

import gst.trainingcourse.lesson7_ex2_hieunt94.model.Author;

public class AuthorData {
    private static AuthorData instance;

    private List<Author> allAuthorList;

    public static AuthorData getInstance() {
        if(instance == null) {
            instance = new AuthorData();
        }
        return instance;
    }

    private AuthorData() {
        generateData();
    }

    public Author findAuthorById(int id) {
        for(Author author: allAuthorList) {
            if(author.getId() == id) {
                return author;
            }
        }
        return null;
    }

    public List<Author> getAllAuthorList() {
        return allAuthorList;
    }

    private void generateData() {
        allAuthorList = new ArrayList<>();
        allAuthorList.add(new Author(1, "Ed Sheeran", "Cross Me"));
        allAuthorList.add(new Author(2, "Shawn Mendes & Camila Cabello", "Senorita"));
        allAuthorList.add(new Author(3,"Maroon5", "Sugar"));
        allAuthorList.add(new Author(4, "Sigala & Becky Hill", "Wish You Well"));
        allAuthorList.add(new Author(5, "Mabel", "Mad Love"));
    }
}

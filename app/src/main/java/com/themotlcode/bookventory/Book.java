package com.themotlcode.bookventory;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

@Entity
public class Book {
    @PrimaryKey
    @NonNull
    private String ISBN = "";
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "authors")
    @TypeConverters(Converters.class)
    private ArrayList<String> authors;
    @ColumnInfo(name = "publish_date")
    private String publishDate;
    @ColumnInfo(name = "count")
    private int count;

    public Book(String ISBN, String title, ArrayList<String> authors, String publishDate, int count) {
        setISBN(ISBN);
        setTitle(title);
        setAuthors(authors);
        setPublishDate(publishDate);
        setCount(count);
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getAuthors() {
        ArrayList<String> copy = new ArrayList<>();
        for (String author : authors) {
            copy.add(author);
        }
        return copy;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public int getCount() {
        return count;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = new ArrayList<>();
        if (authors != null) {
            for (String author : authors) {
                this.authors.add(author);
            }
        }
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public void setCount(int count) {
        this.count = count;
    }

}

package com.themotlcode.bookventory;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface BookDao {
    @Query("SELECT * FROM book")
    List<Book> getAll();

    @Query("SELECT * FROM book WHERE ISBN IN (:bookIds)")
    List<Book> loadAllByIds(String[] bookIds);

    @Query("SELECT * FROM book WHERE ISBN LIKE :ISBN LIMIT 1")
    Book findByISBN(String ISBN);

    @Insert
    void insert(Book book);

    @Delete
    void delete(Book book);
}

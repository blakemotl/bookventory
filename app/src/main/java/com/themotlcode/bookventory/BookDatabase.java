package com.themotlcode.bookventory;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Book.class}, version = 1)
public abstract class BookDatabase extends RoomDatabase {
    public abstract BookDao bookDao();
}

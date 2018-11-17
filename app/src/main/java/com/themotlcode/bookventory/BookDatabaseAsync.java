package com.themotlcode.bookventory;

import android.os.AsyncTask;
import android.util.Log;

public class BookDatabaseAsync extends AsyncTask<String, Void, String> {

    private final BookDao mDao;

    BookDatabaseAsync(BookDatabase db) {
        mDao = db.bookDao();
    }

    @Override
    protected String doInBackground(final String... params) {
        String action = params[0];
        String result = "";
        if (action.equals("get")) {
            String isbn = params[1];
            Book dbResult = mDao.findByISBN(isbn);
            if (dbResult != null) {
                result = dbResult.getISBN();
            }
        }
        else if (action.equals("add")) {
            String isbn = params[1];
            Book exists = mDao.findByISBN(isbn);
            if(exists == null) {
                Log.d("Added Book", isbn);
                mDao.insert(new Book(isbn, "", null, "", 0));
            }
            else {
                Log.d("Book Exists", isbn);
                result = null;
            }
        }
        return result;
    }
}

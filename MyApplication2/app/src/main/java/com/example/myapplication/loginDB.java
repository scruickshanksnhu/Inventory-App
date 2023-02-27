//Steven Cruickshank
//Project 3

package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class loginDB extends SQLiteOpenHelper {
    // creating a constant variables for our database.

    private static final String DB_NAME = "loginDB";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "login";
    private static final String ID_COL = "id";
    private static final String NAME_COL = "username";
    private static final String PW_COL = "password";
    public loginDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        //using a String to create the DB table
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + PW_COL + " TEXT)";

        //executing the query on the db
        db.execSQL(query);
    }

    //To add a new item into the db.
    public void addLoginInfo(String userName, String password) {

        //initiating the database object
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        //putting each value into the associated column
        values.put(NAME_COL, userName);
        values.put(PW_COL, password);

        //insert the login info into the table
        db.insert(TABLE_NAME, null, values);

        //close the db
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}

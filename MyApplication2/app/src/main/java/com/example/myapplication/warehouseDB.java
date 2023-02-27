//Steven Cruickshank
//Project 3 - Inventory App

package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class warehouseDB extends SQLiteOpenHelper {
    // creating a constant variables for our database.
    private static final String DB_NAME = "whDB2";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "warehouse2";
    private static final String ID_COL = "id";
    private static final String NAME_COL = "name";
    private static final String DESCRIPTION_COL = "description";
    private static final String invAmt_COL = "amount";

    // creating a constructor for our database handler.
    public warehouseDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // using SQLite to create a db
    @Override
    public void onCreate(SQLiteDatabase db) {
        // create the table
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + invAmt_COL + " TEXT,"
                + DESCRIPTION_COL + " TEXT)";


        // execute the query
        db.execSQL(query);
    }

    // add items to the sqlite database.
    public void addNewItem(String iName, String iDescription, int amt) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(NAME_COL, iName);
        values.put(DESCRIPTION_COL, iDescription);
        values.put(invAmt_COL, amt);

        db.insert(TABLE_NAME, null, values);

        // close db
        db.close();
    }

    //reads every DB item
    public ArrayList<whInventory> readCourses() {
       SQLiteDatabase db = this.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        ArrayList<whInventory> invList = new ArrayList<>();

        // moving our cursor to beginning.
        if (c.moveToFirst()) {
            do {
                // pulling data line by line
                invList.add(new whInventory(c.getString(1),
                        c.getString(2),
                        c.getString(3)));
            } while (c.moveToNext());
        }
        // close the cursor
        c.close();
        return invList;
    }
    public void updateItem(String iName, String iDescription, int amt) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }};



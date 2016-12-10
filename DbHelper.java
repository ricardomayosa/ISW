package com.example.rmayo.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rmayo on 11/11/2016.
 */
public class DbHelper extends SQLiteOpenHelper{

    private static final int DB_SCHEME_VERSION = 1;
    private static final String DB_NAME = "usuarios.db";
    private static final String TABLE_NAME = "usuarios";
    private static final String CN_ID = "id";
    private static final String CN_NAME = "_name";
    private static final String CN_EMAIL = "email";
    private static final String CN_USER = "user";
    private static final String CN_PASS = "password";


    SQLiteDatabase db;

    public static final String CREATE_TABLE = "create table " + TABLE_NAME + " ("
            + CN_ID    + " integer primary key not null,"
            + CN_NAME  + " text not null,"
            + CN_EMAIL + " text not null,"
            + CN_USER  + " text not null,"
            + CN_PASS  + " text not null);";


    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_SCHEME_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);
        this.db = db;
    }

    public void insertContact(Contact c){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        values.put(CN_ID, count);
        values.put(CN_NAME, c.getName());
        values.put(CN_USER, c.getUname());
        values.put(CN_EMAIL, c.getEmail());
        values.put(CN_PASS, c.getPass());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public String searchPass(String uname){
        db = this.getWritableDatabase();
        String query = "select " + CN_USER + ", " + CN_PASS + " from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found";

        if(cursor.moveToFirst()){
            do {
                a = cursor.getString(0);

                if (a.equals(uname)){
                    b = cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + CREATE_TABLE;
        db.execSQL(query);
        this.onCreate(db);
    }
}
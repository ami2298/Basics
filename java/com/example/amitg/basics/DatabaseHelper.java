package com.example.amitg.basics;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by amitg on 7/4/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="user.db";
    private static final String TABLE_NAME="user";
    private static final String USER_ID="id";
    private static final String USER_NAME="name";
    private static final String USER_EMAIL="email";
    private static final String USER_UNAME="uname";
    private static final String USER_PASS="pass";
    SQLiteDatabase db;
    private static final String TABLE_CREATE="create table user (id integer primary key not null,"+
    "name text not null , email text not null , uname text not null , pass text not null);";

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db=db;

    }

    public void onInsert(Contact c){
        db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        String query="select * from user";
        Cursor cursor =db.rawQuery(query,null);
        int count = cursor.getCount();
        contentValues.put(USER_ID,count);
        contentValues.put(USER_NAME,c.getName());
        contentValues.put(USER_EMAIL,c.getEmail());
        contentValues.put(USER_UNAME,c.getUname());
        contentValues.put(USER_PASS,c.getPass());

        db.insert(TABLE_NAME,null,contentValues);
        db.close();
    }

    public String searchPass(String uname){
        db=this.getReadableDatabase();
        String query ="select uname,pass from user";
        Cursor cursor=db.rawQuery(query , null);
        String u, p;
        p="Not Found";
        if(cursor.moveToFirst()){
            do {
                u=cursor.getString(0);
                if(u.equals(uname)){
                    p=cursor.getString(1);
                    break;
                }


            }while (cursor.moveToNext());
        }
        return p;

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query="DROP TABLE IF EXIST"+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}

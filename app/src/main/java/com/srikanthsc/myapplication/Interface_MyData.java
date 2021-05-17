package com.srikanthsc.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public interface Interface_MyData {





    public void onCreate(SQLiteDatabase DB);
    public void onUpgrade(SQLiteDatabase DB, int i, int i1);
    public Boolean insertuserdata(String name, String contact, String dob);
    public Boolean updateuserdata(String name, String contact, String dob);
    public Boolean deletedata (String name);
    public Cursor getdata ();
}

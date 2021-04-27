package com.example.blooddonation;
import android.R.string;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class UserDbHelper extends SQLiteOpenHelper {
    private static String databasename = "blooddonation";
    SQLiteDatabase BlooddonationDatabase;

    public UserDbHelper(@Nullable Context context) {
        super(context, databasename, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table User(id integer primary key autoincrement not null," + "name text not null,email text not null,password text not null,Phonenumber text,bloodtype text,city text,area text)");
        db.execSQL("create table Hospital(id integer primary key autoincrement not null," + "email text not null,password text not null,RegistrationNumber text)");
        db.execSQL("create table Post(id integer primary key autoincrement not null,"+"bloodtype text not null,status text not null,numberofdonors text not null,description text not null,patientname text not null )");

       /* db.execSQL("INSERT INTO Hospital (name, registeration, area,city,email,password)\n" +
                "VALUES ('Helal@gmail.com', 1,'Nasr City','Cairo');");
        db.execSQL("INSERT INTO Hospital (name, registeration, area,city)\n" +
                "VALUES ('Sanabel@gmail.com', 3,'Hadayek Elkobba','Cairo');");
        db.execSQL("INSERT INTO Hospital (name, registeration, area,city)\n" +
                "VALUES ('gawy@gmail.com', 2,'5th Settelment','Cairo');");
*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists User");
        db.execSQL("drop table if exists Hospital");
        db.execSQL("drop table if exists Post");

        onCreate(db);
    }

    public long CreateNewUser(String name, String email, String password, String phoneNumber,String BloodType, String City, String Area) {
        ContentValues row = new ContentValues();
        row.put("name", name);
        row.put("email", email);
        row.put("password", password);
        row.put("Phonenumber",phoneNumber);
        row.put("bloodtype", BloodType);
        row.put("city", City);
        row.put("area", Area);
        BlooddonationDatabase = getWritableDatabase();
        long ret=BlooddonationDatabase.insert("User", null, row);
        return ret;
    }
    public long CreateNewHospital( String email, String password, String RegistrationNumber)
    {
        ContentValues row = new ContentValues();

        row.put("email", email);
        row.put("password", password);
        row.put("RegistrationNumber",RegistrationNumber);
        //BlooddonationDatabase.update("Hospital", row, "RegistrationNumber like \\'%\"+RegistrationNumber+\"%\\'", new String[]{RegistrationNumber});

        BlooddonationDatabase = getWritableDatabase();
        long ret=BlooddonationDatabase.insert("Hospital", null, row);
        return ret;
    }

    public long CreateNewPost(String bloodtype , String status, String numberofdonors , String description, String patientname)
    {
        ContentValues row = new ContentValues();

        row.put ("bloodtype", bloodtype);
        row.put("status" , status);
        row.put("numberofdonors",numberofdonors);
        row.put("description", description);
        row.put("patientname",patientname);

        BlooddonationDatabase = getWritableDatabase();
        long ret = BlooddonationDatabase.insert("Post",null,row);
        return ret;
    }

    public Cursor Fetch_all_Users()
    {
        BlooddonationDatabase = getReadableDatabase();
        String[] rowDetails = {"email", "password", "phoneNumber","bloodtype", "city", "area"};
        Cursor cursor = BlooddonationDatabase.query("Users", rowDetails, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            BlooddonationDatabase.close();
        }
    return cursor;
    }
    public Cursor Fetch_User(String Email,String Password)
    {
        BlooddonationDatabase = getReadableDatabase();
        String[] rowDetails = {"name", "email", "password", "phoneNumber","bloodtype", "city", "area"};
        String[]arg={Email,Password};
        Cursor cursor = BlooddonationDatabase.rawQuery("Select * from User where email like \'%"+Email+"%\' and Password like \'%"+Password+"%\'",arg);
        if (cursor != null) {
            cursor.moveToFirst();
            BlooddonationDatabase.close();
        }
        return cursor;
    }

    public Cursor Fetch_Hospital(String Email,String Password)
    {
        BlooddonationDatabase = getReadableDatabase();
        String[] rowDetails = {"email", "password"};
        String[]arg={Email,Password};
        Cursor cursor = BlooddonationDatabase.rawQuery("Select * from Hospital where email like \'%"+Email+"%\' and password like \'%"+Password+"%\'",arg);
        if (cursor != null) {
            cursor.moveToFirst();
            BlooddonationDatabase.close();
        }
        return cursor;
    }


}
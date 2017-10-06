package com.invisino.invisino;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Nicole on 10/5/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Invisino";
    private static final String USER_INFO = "UserInformation";

    private static final String USERNAME = "User";
    private static final String PASSWORD = "Password";
    private static final String LOCATION = "Location";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_USER_TABLE = "CREATE TABLE" + USER_INFO + "("
                + USERNAME + "TEXT PRIMARY KEY," + PASSWORD + "TEXT,"
                + LOCATION + "TEXT" + ")";
        db.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + USER_INFO);
        onCreate(db);
    }

    public void addUser(String user, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USERNAME, user);
        values.put(PASSWORD, password);

        /*while (!userExists(user)){
            Log.e(getClass().getSimpleName(),"Username already exists");
            //ask for new username
        }*/
        //should we combine verification of both username and password or leave as is?
        //verify username
        if(!userExists(user)) {
            db.insert(USER_INFO, null, values);
        }
        else{
            //display error message on screen?
            Log.e(getClass().getSimpleName(),"Username already exists");
            //ask for new username
            //values.put(USERNAME, user);
        }
        //verify password
        if(!passwordExists(user)) {
            db.insert(USER_INFO, null, values);
        }
        else{
            //display error message on screen?
            Log.e(getClass().getSimpleName(),"Password already exists");
            //ask for new password
            //values.put(PASSWORD, password);
        }
        db.close();
    }

    public int updatePassword(String user, String newPassword/*User user*/){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USERNAME, user);
        //verify password
        if(!passwordExists(user)) {
            //return db.update(USER_INFO, values, PASSWORD + " = ", new String[] {newPassword});
        }
        else{
            //display error message on screen?
            Log.e(getClass().getSimpleName(),"Password already exists");
            //ask for new password
            //values.put(PASSWORD, password);
        }
        return db.update(USER_INFO, values, PASSWORD + " = ", new String[] {newPassword});
        //values.put(LOCATION, User.class);
    }

    private boolean userExists(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = null;
        String check = "SELECT " + USERNAME + " FROM " + USER_INFO + "WHERE " + USERNAME + " = " + username;
        c = db.rawQuery(check, null);
        boolean exists = (c.getCount() > 0);
        c.close();
        return exists;
    }

    private boolean passwordExists(String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = null;
        String check = "SELECT " + PASSWORD + " FROM " + USER_INFO + "WHERE " + PASSWORD + " = " + password;
        c = db.rawQuery(check, null);
        boolean exists = (c.getCount() > 0);
        c.close();
        return exists;
    }
}
package com.invisino.invisino;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.util.Log;

/**
 * Created by Nicole on 10/6/2017.
 */

//Maybe right? Do not know how to connect DB to DBHelper.

public class InvisinoDB extends AppCompatActivity {

    private final String DATABASE_NAME = "Invisino";
    private final String USER_INFO = "UserInformation";

    private static final String USERNAME = "User";
    private static final String PASSWORD = "Password";
    private static final String LOCATION = "Location";

    DatabaseHelper Helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_camera);
        SQLiteDatabase db =  null;

        try {
            db = this.openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE,null);
            db.execSQL("CREATE TABLE IF NOT EXISTS " + USER_INFO + "("
                    + USERNAME + "TEXT PRIMARY KEY," + PASSWORD + "TEXT,"
                    + LOCATION + "TEXT" + ")");
        } catch (SQLiteException se){
            Log.e(getClass().getSimpleName(), "Could not create or open the database");
        }
    }

    protected void addUser(String user, String password){
        Helper.addUser(user,password/*new User(user, password)*/);
    }

    protected void updatePassword(String user, String newPassword){
        Helper.updatePassword(user,newPassword);
    }
}

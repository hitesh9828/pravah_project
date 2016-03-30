package com.thefourstars.myapp.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Duggu on 15-Dec-15.
 */
public class DatabaseHandler extends SQLiteOpenHelper{
    private final static String DATABASE_NAME = "login_database";
    private final static int DATABASE_VERSION = 1;
    
    //TAbles
    private final static String TABLE_LOGIN_DETAILS = "login_table";
    //
    private final static String KEY_ID = "id";
    private final static String KEY_NAME = "name";
    private final static String KEY_USERNAME = "username";
    private final static String KEY_PASSWORD = "password";
    private final static String KEY_EMAIL = "email";
    private final static String KEY_COLLEGE_NAME = "college_name";
    private final static String KEY_SEX = "sex";

    //database Instance
    private SQLiteDatabase db;

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE "+TABLE_LOGIN_DETAILS
                +"("+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +KEY_NAME           +" TEXT, "
                +KEY_USERNAME       +" TEXT UNIQUE, "
                +KEY_PASSWORD       +" TEXT, "
                +KEY_EMAIL          +" TEXT UNIQUE, "
                +KEY_COLLEGE_NAME   +" TEXT, "
                +KEY_SEX            +" TEXT);";
    db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST "+TABLE_LOGIN_DETAILS);
    }
    //insert Data for users
    public long insertDetails(String name,String userName,String passWord,String email,String collegeName,String sex){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME,name);
        values.put(KEY_USERNAME,userName);
        values.put(KEY_PASSWORD,passWord);
        values.put(KEY_EMAIL,email);
        values.put(KEY_COLLEGE_NAME,collegeName);
        values.put(KEY_SEX,sex);
        long effected = db.insert(TABLE_LOGIN_DETAILS,null,values);
        db.close();
        return effected;
    }
    //get user Login Details
    public String [] getLoginDetails(String userName){
        String [] details = new String[2];
        db = this.getWritableDatabase();
        String query = "SELECT * FROM "+TABLE_LOGIN_DETAILS+" WHERE "+KEY_USERNAME+" = '"+userName+"';";
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do {
                details[0] = cursor.getString(2);
                details[1] = cursor.getString(3);
            }while(cursor.moveToNext());
        }
        return details;
    }
}

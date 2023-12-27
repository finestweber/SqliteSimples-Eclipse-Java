package com.example.banc;

//Nome da classe: ContactDBHelper.java
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ContactDBHelper extends SQLiteOpenHelper {
 public static final int DATABASE_VERSION = 1;
 public static final String DATABASE_NAME = "Contacts.db";

 private static final String SQL_CREATE_ENTRIES =
         "CREATE TABLE " + ContactContract.ContactEntry.TABLE_NAME + " (" +
                 ContactContract.ContactEntry._ID + " INTEGER PRIMARY KEY," +
                 ContactContract.ContactEntry.COLUMN_NAME_NAME + " TEXT," +
                 ContactContract.ContactEntry.COLUMN_NAME_EMAIL + " TEXT)";

 private static final String SQL_DELETE_ENTRIES =
         "DROP TABLE IF EXISTS " + ContactContract.ContactEntry.TABLE_NAME;

 public ContactDBHelper(Context context) {
     super(context, DATABASE_NAME, null, DATABASE_VERSION);
 }

 @Override
 public void onCreate(SQLiteDatabase db) {
     db.execSQL(SQL_CREATE_ENTRIES);
 }

 @Override
 public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     db.execSQL(SQL_DELETE_ENTRIES);
     onCreate(db);
 }
}

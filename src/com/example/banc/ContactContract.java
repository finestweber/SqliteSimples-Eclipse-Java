package com.example.banc;

//Nome da classe: Contact.java
import android.provider.BaseColumns;

public final class ContactContract {
 private ContactContract() {}

 public static class ContactEntry implements BaseColumns {
     public static final String TABLE_NAME = "contacts";
     public static final String COLUMN_NAME_NAME = "name";
     public static final String COLUMN_NAME_EMAIL = "email";
 }
}

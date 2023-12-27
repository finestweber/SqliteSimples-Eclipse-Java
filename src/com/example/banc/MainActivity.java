package com.example.banc;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText editTextName, editTextEmail;
    private Button buttonSave;
    private ContactDBHelper dbHelper;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		dbHelper = new ContactDBHelper(this);

        editTextName = (EditText)findViewById(R.id.editTextName);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        buttonSave = (Button) findViewById(R.id.buttonSave);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveContact();
            }
        });
	}
	private void saveContact() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ContactContract.ContactEntry.COLUMN_NAME_NAME, editTextName.getText().toString());
        values.put(ContactContract.ContactEntry.COLUMN_NAME_EMAIL, editTextEmail.getText().toString());

        long newRowId = db.insert(ContactContract.ContactEntry.TABLE_NAME, null, values);
        if (newRowId != -1) {
            showToast("Contact saved successfully");
            // Clear the input fields after successful save
            editTextName.setText("");
            editTextEmail.setText("");
        } else {
            showToast("Failed to save contact");
        }

        db.close();
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
        

        

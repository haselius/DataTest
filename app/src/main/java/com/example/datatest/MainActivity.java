package com.example.datatest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnAdd;
    EditText etName, etPass;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.bntAdd);
        btnAdd.setOnClickListener(this);


        etName = findViewById(R.id.etName);
        etPass = findViewById(R.id.etPass);

        dbHelper = new DBHelper(this);
    }

    @Override
    public void onClick(View v) {

        String login = etName.getText().toString();
        String pass = etPass.getText().toString();

        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();


        switch (v.getId()) {

            case R.id.bntAdd:
                contentValues.put(DBHelper.KEY_LOGIN, login);
                contentValues.put(DBHelper.KEY_PASS, pass);

                database.insert(DBHelper.TABLE_CONTACTS, null, contentValues);
                break;
        }
        dbHelper.close();
    }
}
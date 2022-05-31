package com.hunter.crudsqlite_191103567;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText firstname, lastname;
    TextView textView;
    DB_Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstname = (EditText) findViewById(R.id.editFirstname);
        lastname = (EditText) findViewById(R.id.editLastname);
        textView = (TextView) findViewById(R.id.textview);

        controller = new DB_Controller(this, "", null, 1);
    }

    public void btn_click(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                try {
                    controller.insert_student(firstname.getText().toString(), lastname.getText().toString());
                } catch (SQLiteException e) {
                    Toast.makeText(MainActivity.this, "ALREADY EXIST", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_delete:
                controller.delete_student(firstname.getText().toString());
                break;
            case R.id.btn_list:
                controller.list_all_students(textView);
                break;
        }
    }
}
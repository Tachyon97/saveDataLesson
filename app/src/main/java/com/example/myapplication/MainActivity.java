package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final String IDENTITY_SHAREDPREFERENCE = "IDENTITY_SHAREDPREFERENCE";
    final String NAME_KEY = "namekey";

    EditText nameField;
    TextView viewText;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameField = findViewById(R.id.edit);
        viewText = findViewById(R.id.text);
        sharedPreferences = getSharedPreferences(IDENTITY_SHAREDPREFERENCE, Context.MODE_PRIVATE);

        String savedName = sharedPreferences.getString(NAME_KEY, null);
        viewText.setText(savedName);

    }

    public void saveName(View view) {
        // Felhantering
        String name = "";
        if (nameField != null) {
            name = nameField.getText().toString();
        }
        if (viewText != null) {
            viewText.setText(name);
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(NAME_KEY, name);
        editor.commit();
    }
}

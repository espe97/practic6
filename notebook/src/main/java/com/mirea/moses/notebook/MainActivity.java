package com.mirea.moses.notebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, email;
    Button btnSave, btnNext;
    SharedPreferences sp;
    String nameStr, emailStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.editTextName);
        email = findViewById(R.id.editTextEmail);
        btnSave = findViewById(R.id.btnSave);
        btnNext = findViewById(R.id.btnNext);
        sp = getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameStr = name.getText().toString();
                emailStr = email.getText().toString();

                SharedPreferences.Editor editor = sp.edit();
                editor.putString("name", nameStr);
                editor.putString("email", emailStr);
                editor.commit();
                Toast.makeText(MainActivity.this, "Information Save", Toast.LENGTH_LONG).show();
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NextPage.class);
                startActivity(intent);
            }
        });
    }
}
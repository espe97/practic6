package com.mirea.moses.notebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NextPage extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_page);
        TextView textView1, textView2;
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("MyUserPrefs",
                Context.MODE_PRIVATE);
        String name = sp.getString("name", "");
        String email = sp.getString("email", "");

        textView1.setText(name);
        textView2.setText(email);

    }
}

package com.example.explicitintentvideo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Activity2 extends AppCompatActivity {
    TextView tvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        tvWelcome = findViewById(R.id.tvWelcome);

        String name = getIntent().getStringExtra("name");

        tvWelcome.setText(name + ", welcome to activity2!");
    }
}

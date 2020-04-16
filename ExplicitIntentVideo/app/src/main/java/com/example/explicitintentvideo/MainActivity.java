package com.example.explicitintentvideo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    Button btnActivity2;
    Button btnActivity3;
    TextView tvResults;

    final int ACTIVITY3 = 3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        btnActivity2 = findViewById(R.id.btnActivity2);
        btnActivity3 = findViewById(R.id.btnActivity3);
        tvResults = findViewById(R.id.tvResults);

        btnActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etName.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Please enter field!", Toast.LENGTH_SHORT).show();

                }
                else{
                    String name= etName.getText().toString().trim();

                    Intent intent = new Intent(MainActivity.this, com.example.explicitintentvideo.Activity2.class);
                    intent.putExtra("name",name);
                    startActivity(intent);
                }


            }

        });

        btnActivity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.explicitintentvideo.Activity3.class);
                startActivityForResult(intent, ACTIVITY3);

            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ACTIVITY3){
            if (resultCode == RESULT_OK){
                tvResults.setText(data.getStringExtra("surname"));
            }
            if (resultCode == RESULT_CANCELED) {
                tvResults.setText("No data received!");
            }
        }

    }
}

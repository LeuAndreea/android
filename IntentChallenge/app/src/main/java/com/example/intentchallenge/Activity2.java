package com.example.intentchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity implements View.OnClickListener {
    EditText etName, etNumber, etWebsite, etLocation;
    ImageView ivSad, ivNormal, ivHappy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        etName = findViewById(R.id.etName);
        etNumber = findViewById(R.id.etNumber);
        etWebsite = findViewById(R.id.etWebsite);
        etLocation = findViewById(R.id.etLocation);
        ivSad = findViewById(R.id.ivSad);
        ivNormal = findViewById(R.id.ivNormal);
        ivHappy = findViewById(R.id.ivHappy);

        ivSad.setOnClickListener(this);
        ivNormal.setOnClickListener(this);
        ivHappy.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if (etName.getText().toString().isEmpty() || etNumber.getText().toString().isEmpty() ||
                etWebsite.getText().toString().isEmpty() || etLocation.getText().toString().isEmpty())
            Toast.makeText(Activity2.this, "Please enter all fields!", Toast.LENGTH_SHORT).show();
        else {
            Intent intent = new Intent();

            intent.putExtra("name", etName.getText().toString().trim());
            intent.putExtra("number", etNumber.getText().toString().trim());
            intent.putExtra("website", etWebsite.getText().toString().trim());
            intent.putExtra("location", etLocation.getText().toString().trim());


            if (v.getId() == R.id.ivHappy)
                intent.putExtra("pictureType", "happy");
            else if (v.getId() == R.id.ivNormal)
                intent.putExtra("pictureType", "normal");
            else
                intent.putExtra("pictureType", "sad");

            setResult(RESULT_OK, intent);
            Activity2.this.finish();
        }
    }

}

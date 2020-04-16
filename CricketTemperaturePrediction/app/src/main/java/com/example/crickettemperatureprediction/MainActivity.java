package com.example.crickettemperatureprediction;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    TextView tvInfo;
    EditText etNbOfChirps;
    Button btnCalculateTemp;
    TextView tvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = findViewById(R.id.tvInfo);
        etNbOfChirps =findViewById(R.id.etNbOfChirps);
        btnCalculateTemp =findViewById(R.id.btnCalculateTemp);
        tvResult = findViewById(R.id.tvResult);
        final DecimalFormat formatter;

        tvInfo.setText(R.string.info);
        formatter= new DecimalFormat("#0.00");

        btnCalculateTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etNbOfChirps.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter field!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Double nbOfChirps = Double.parseDouble(etNbOfChirps.getText().toString().trim());

                    Double result = nbOfChirps / 3 + 4;

                    String text = (getString(R.string.result1) + formatter.format(result) + getString(R.string.result2));
                    tvResult.setText(text);
                }
            }
        });
    }
}

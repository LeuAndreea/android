package com.example.lifecycleevent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("Life cycle event", "In on create()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Life cycle event", "In on resume()");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Life cycle event", "In on pause()");


    }



    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Life cycle event", "In on stop()");


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Life cycle event", "In on start()");




    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Life cycle event", "In on destroy()");



    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("Life cycle event", "In on restore()");

    }
}


package com.example.cwiczenia4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MonteCarlo extends AppCompatActivity {
    Algorithms algorithms;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monte_carlo);
        algorithms = new Algorithms();
        setSupportActionBar(findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();

        double ilosc_punktow = intent.getDoubleExtra("ilosc_punktow",0);
        Log.d(MainActivity.TAG,"<------------- ilosc punktow: "
                +String.format("%.1f", ilosc_punktow) );

        double wartosc_pi = new Algorithms().monteCarlo(ilosc_punktow);

        Log.d(MainActivity.TAG,"<-------------pierwiastek---------------------->"+String.format("%.9f",wartosc_pi));
    }




    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu1, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.losuj:
                algorithms.random6();
                return true;
            case R.id.newtonraphson:
                algorithms.newtonRaphson(25,0.001);
                return true;
            case R.id.montecarlo:
                algorithms.monteCarlo(1000000.0);
                return true;
            case R.id.sortzliczanie:
                algorithms.countingSort();
                return true;
            default:   return super.onOptionsItemSelected(item);
        }
    }
}
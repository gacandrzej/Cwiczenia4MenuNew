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

import java.util.Objects;

public class NewtonRaphson extends AppCompatActivity {
    Algorithms algorithms;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newton_raphson);
        algorithms = new Algorithms();
        setSupportActionBar(findViewById(R.id.toolbar));
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        double l = intent.getDoubleExtra("liczba",0);
        double prec = intent.getDoubleExtra("precyzja",0);


        Log.d(MainActivity.TAG,"<-------------liczba i precyzja: "
                +String.format("%.9f", l)+" "+String.format("%.9f", prec));

        double pierwiastek = new Algorithms().newtonRaphson(l,prec);

        Log.d(MainActivity.TAG,"<-------------pierwiastek---------------------->"+pierwiastek);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu1, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.losuj) {
            algorithms.random6();
            return true;
        } else if (itemId == R.id.newtonraphson) {
            algorithms.newtonRaphson(25, 0.001);
            return true;
        } else if (itemId == R.id.montecarlo) {
            algorithms.monteCarlo(1000000.0);
            return true;
        } else if (itemId == R.id.sortzliczanie) {
            algorithms.countingSort();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        Log.v(MainActivity.TAG, "--------NewtonRaphson-------onSupportNavigateUp()");
        finish();
        return true;
    }


}
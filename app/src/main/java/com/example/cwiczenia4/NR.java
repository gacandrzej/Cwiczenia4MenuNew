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
import android.widget.Toast;

public class NR extends AppCompatActivity {
    Algorithms algorithms;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nr);
        algorithms = new Algorithms();
        setSupportActionBar(findViewById(R.id.toolbar2));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        double l = intent.getDoubleExtra("liczba",0);
        double prec = intent.getDoubleExtra("precyzja",0);

        // Capture the layout's TextView and set the string as its text
//        TextView textView = findViewById(R.id.extra);
//        textView.setText(liczba);
        Log.d("menu123","<-------------liczba i precyzja: "+String.format("%.9f", l)+" "+String.format("%.9f", prec));
        //TextView textView2 = findViewById(R.id.pierwiastek);
        double pierwiastek = new Algorithms().newtonRaphson(l,prec);
       // textView2.setText(String.valueOf(pierwiastek));
        Log.d("menu123","<-------------pierwiastek---------------------->"+pierwiastek);
    }


    @Override
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
                               algorithms.monteCarlo();
                               return true;
            case R.id.sortzliczanie:
                                    algorithms.countingSort();
                                    return true;
            default:   return super.onOptionsItemSelected(item);
        }
    }

}
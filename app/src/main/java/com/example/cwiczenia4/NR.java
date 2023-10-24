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

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nr);

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
        double pierwiastek = newtonRaphson(l,prec);
       // textView2.setText(String.valueOf(pierwiastek));
        Log.d("menu123","<-------------pierwiastek---------------------->"+pierwiastek);
    }

    private double newtonRaphson(double x, double d) {
        double a=5;
        while(Math.abs(x/a-a)>d){
            a=(x/a+a)/2;
            Log.i("NR" ,x/a + " " +a );
        }

        Toast.makeText(getApplicationContext(),
                "Newton-Raphson",
                Toast.LENGTH_SHORT).show();
        Log.i("NR","------------------");
        //
        return a;
    }


}
package com.example.cwiczenia4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button newtonR;
    Algorithms algorithms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(findViewById(R.id.toolbar));

        newtonR = findViewById(R.id.button2);
        newtonR.setOnClickListener(v->{
            intentNewtonRaphson();
        });
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
                intentNewtonRaphson();
                return true;
            case R.id.montecarlo:
                 intentMonteCarlo();
                return true;
            case R.id.sortzliczanie:
                 intentCountingSort();
                return true;
            case R.id.aboutAuthor: aboutAuthor(); return true;
            default:   return super.onOptionsItemSelected(item);
        }
    }

    private void intentCountingSort() {

    }

    private void intentMonteCarlo() {
        Intent intent = new Intent(this,MonteCarlo.class);
        intent.putExtra("ilosc_punktow", 1000000.0);
        startActivity(intent);
        Log.v("menu123","<--------------- monteCarlo()");
    }

    private void aboutAuthor() {
        AlertDialog builder = new AlertDialog.Builder(this)
                .setMessage("Author: Andrzej Gac")
                .setTitle("---Simple alert application---")
                .setNegativeButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i("menu123","------------------------> ok");
                    }
                })
                .setPositiveButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i("menu123","------------------------> cancel");
                    }
                })
                .create();
        builder.show();
    }

    private void intentNewtonRaphson() {
        Toast.makeText(this, "NewtonRaphson()", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, NewtonRaphson.class);
        intent.putExtra("liczba", 9.0);
        intent.putExtra("precyzja", 0.0001);
        startActivity(intent);
        Log.v("menu123","<--------------- NewtonRaphson()");
    }



    public void LosujLiczby(View view) {

        Toast.makeText(this, "Test przycisku", Toast.LENGTH_SHORT).show();

        Log.v("menu123","<--------------- Test przycisku");
    }
}
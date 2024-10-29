package com.example.cwiczenia4;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Algorithms algorithms;
    Button btn_newton;
    public static final String TAG = "Marcin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(findViewById(R.id.toolbar));
        Log.d(TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");
        btn_newton = findViewById(R.id.btnnewtonraphson);
        btn_newton.setOnClickListener(v -> {
            Log.d(TAG, "onClick: ");
            intentNewtonRaphson();
        });
        algorithms = new Algorithms();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.losuj) {
            algorithms.random6();
            return true;
        } else if (item.getItemId() == R.id.newtonraphson) {
            intentNewtonRaphson();
            Log.d(TAG, "onOptionsItemSelected: ");
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.montecarlo) {
            intentMonteCarlo();
            Log.d(TAG, "onOptionsItemSelected: ");
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.sortzliczanie) {
            intentCountingSort();
            return true;
        } else if (item.getItemId() == R.id.aboutAuthor) {
            aboutAuthor();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void intentCountingSort() {

    }

    private void intentMonteCarlo() {
        EditText iloscPunktow = findViewById(R.id.iloscPunktow);
        double ilPunktow = Double.parseDouble(String.valueOf(iloscPunktow.getText()));
        Intent intent = new Intent(this, MonteCarlo.class);
        intent.putExtra("ilosc_punktow", ilPunktow);
        startActivity(intent);
        Log.v(TAG, "<--------------- monteCarlo()");
    }

    private void aboutAuthor() {
        AlertDialog builder = new AlertDialog.Builder(this)
                .setMessage("Author: Andrzej Gac")
                .setTitle("---Simple alert application---")
                .setNegativeButton(R.string.ok, (dialog, which) -> Log.i(TAG, "------------------------> ok"))
                .setPositiveButton(R.string.cancel, (dialog, which) -> Log.i(TAG, "------------------------> cancel"))
                .create();
        builder.show();
    }

    private void intentNewtonRaphson() {
        Toast.makeText(this, "NewtonRaphson()", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, NewtonRaphson.class);
        intent.putExtra("liczba", 9.0);
        intent.putExtra("precyzja", 0.0001);
        startActivity(intent);
        Log.v(TAG, "<--------------- NewtonRaphson()");
    }


    public void LosujLiczby(View view) {
        Toast.makeText(this, "Test przycisku", Toast.LENGTH_SHORT).show();
        Log.v(MainActivity.TAG, "<--------------- Test przycisku");
    }


}
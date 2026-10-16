package com.example.cwiczenia4;

import static com.example.cwiczenia4.MainActivity.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class NewtonRaphson extends AppCompatActivity {
    Algorithms algorithms;
    StringBuilder sb = new StringBuilder();
    TextView textViewWynik;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newton_raphson);
        algorithms = new Algorithms();

        // Zawsze inicjalizujemy widok, żeby nie był nullem
        textViewWynik = findViewById(R.id.textViewWynik);

        // Obsługa paska narzędzi
        Toolbar toolbar = findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
        }

        // Odbieranie danych przekazanych przez Intent
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("liczba") && intent.hasExtra("precyzja")) {
            double liczba = intent.getDoubleExtra("liczba", 0);
            double precyzja = intent.getDoubleExtra("precyzja", 0);

            Log.d(TAG, "<-------------liczba i precyzja: "
                    + String.format("%.9f", liczba) + " " + String.format("%.9f", precyzja));

            // Wywołanie algorytmu obliczeniowego
            double pierwiastek = new Algorithms().newtonRaphson(liczba, precyzja);
            Log.d(TAG, "<-------------pierwiastek---------------------->" + pierwiastek);

            // Formatowanie wyników
            String formatLiczba = String.format("%.2f", liczba);
            String formatPrecyzja = String.format("%.7f", precyzja);
            String formatPierwiastek = String.format("%.4f", pierwiastek);

            // Wyświetlenie wyniku na ekranie
            if (textViewWynik != null) {
                sb.setLength(0);
                sb.append("Liczba: ").append(formatLiczba)
                        .append("\nprecyzja: ").append(formatPrecyzja)
                        .append("\npierwiastek: ").append(formatPierwiastek);
                textViewWynik.setText(sb.toString());
            }
        } else {
            Log.d(TAG, "Brak wymaganych extras w Intent");
            if (textViewWynik != null) {
                textViewWynik.setText("Brak danych wejściowych");
            }
        }
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
        Log.v(TAG, "--------NewtonRaphson-------onSupportNavigateUp()");
        finish();
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "class NewtonRaphson onStart() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "class NewtonRaphson onResume() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "class NewtonRaphson onPause() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "class NewtonRaphson onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "class NewtonRaphson onDestroy() called");
    }
}
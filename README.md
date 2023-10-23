# Cwiczenia4MenuNew
Cwiczenia4MenuNew
![image](https://github.com/gacandrzej/Cwiczenia4MenuNew/assets/82050305/df4b0c4c-b83e-47d8-b1e8-987809fe9846)

```java
public class NR extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nr);

        setSupportActionBar(findViewById(R.id.toolbar2));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
    }
}




------------------------------------------------------------------------
package com.example.cwiczenia4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
Button newtonR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(findViewById(R.id.toolbar));

        newtonR = findViewById(R.id.button2);
        newtonR.setOnClickListener(v->{
            newtonRaphson();
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
            case R.id.losuj: LosujLiczby2(); return true;
            case R.id.newtonraphson: newtonRaphson(); return true;
            case R.id.montecarlo: monteCarlo(); return true;
            default:   return super.onOptionsItemSelected(item);
        }
    }

    private void monteCarlo() {

    }

    private void newtonRaphson() {
        Toast.makeText(this, "NewtonRaphson()", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, NR.class);
        intent.putExtra("liczba", 26);
        intent.putExtra("precyzja", 0.0001);
        startActivity(intent);
        Log.v("menu123","<--------------- NewtonRaphson()");

    }

    private void LosujLiczby2() {
        Toast.makeText(this, "z menu", Toast.LENGTH_SHORT).show();
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        HashSet<Integer> hashSet = new HashSet<>();
        while (hashSet.size()<6){
            Integer nowa = 1+ random.nextInt(49);
            hashSet.add(nowa);
        }
        list.addAll(hashSet);
        Collections.sort(list);
        String napis = "";
        for (int i : list) napis += i + " ";
        Log.v("menu123","<--------------- losuj liczby, posortowane: " + napis);
    }

    public void LosujLiczby(View view) {

        Toast.makeText(this, "Test przycisku", Toast.LENGTH_SHORT).show();

        Log.v("menu123","<--------------- Test przycisku");
    }
}
```

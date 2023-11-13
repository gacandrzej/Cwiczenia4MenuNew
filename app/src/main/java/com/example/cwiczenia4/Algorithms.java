package com.example.cwiczenia4;

import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Algorithms {

    public double newtonRaphson(double x, double d) {
        double a=5;
        while(Math.abs(x/a-a)>d){
            a=(x/a+a)/2;
            Log.i("NR" ,x/a + " " +a );
        }

//        Toast.makeText(getApplicationContext(),
//                "Newton-Raphson",
//                Toast.LENGTH_SHORT).show();
        Log.i("NR","------------------");
        //
        return a;
    }
    public void countingSort(){}
    public double monteCarlo(){}

    public String random6(){
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
        return napis;
    }

}

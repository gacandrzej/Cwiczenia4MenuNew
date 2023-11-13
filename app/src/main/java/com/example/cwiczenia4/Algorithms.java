package com.example.cwiczenia4;

import android.util.Log;
import android.widget.Toast;

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

}

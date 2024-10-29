package com.example.cwiczenia4;

import android.util.Log;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Algorithms {
    Random random;

    public double newtonRaphson(double x, double d) {
        double a=5;
        while(Math.abs(x/a-a)>d){
            a=(x/a+a)/2;
            Log.i("NR" ,x/a + " " +a );
        }
        Log.i("NR","------------------");
        Log.d(MainActivity.TAG, "newtonRaphson() returned: " + a);
        return a;
    }
    public void countingSort(){

    }
    public double monteCarlo(double n){
        random = new Random();
        double T=0.0;
        double R=0.0;
        double a;
        double b;
        do{
            a = random.nextDouble();
            b = random.nextDouble();
            if ( Math.pow(a,2)+Math.pow(b,2) < 1) T++;
            R++;
        }while(R<n);
        return 4.0*T/R;
    }

    public String random6(){
        random = new Random();
            Set<Integer> treeSet = new TreeSet<>();
            while (treeSet.size()<6){
                treeSet.add(1+ random.nextInt(48));
            }

        Log.d(MainActivity.TAG, "random6: list:"+treeSet);
        return "";
    }

}

package com.example.cwiczenia4;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Algorithms {
    public double newtonRaphson(double x, double d) {
        double a = 5;
        while (Math.abs(x / a - a) > d) {
            a = (x / a + a) / 2;
            Log.i("NR", x / a + " " + a);
        }
        Log.d(MainActivity.TAG, "newtonRaphson() returned: " + a);
        return a;
    }

    /** @noinspection DataFlowIssue*/
    public void countingSort() {


        List<Integer> liczby = new ArrayList<>();
        Map<Integer, Integer> liczbymap = new HashMap<>();

        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            liczby.add(random.nextInt(100));
        }

        int highest = Collections.max(liczby);
        for (int i = 0; i < highest; i++) {
            liczbymap.put(i, 0);
        }
        Log.i(MainActivity.TAG, String.valueOf(liczbymap));

        for (Integer x : liczby) {
            if (liczbymap.containsKey(x))
                liczbymap.replace(x, liczbymap.get(x) + 1);
        }
        Log.i(MainActivity.TAG, String.valueOf(liczbymap));
        liczby.clear();

        for (int i = 1; i < liczbymap.size(); i++) {
            for (int y = 0; y < liczbymap.get(i); y++) {
                liczby.add(i);
            }
        }
        StringBuilder text = new StringBuilder();
        for (Integer x : liczby) {
            text.append(x);
            text.append(" ");
        }
        Log.i(MainActivity.TAG, String.valueOf(liczby));

    }

    public double monteCarlo(double n) {
        Random random = new Random();
        double T = 0.0;
        double R = 0.0;
        double a;
        double b;
        do {
            a = random.nextDouble();
            b = random.nextDouble();
            if (Math.pow(a, 2) + Math.pow(b, 2) < 1) T++;
            R++;
        } while (R < n);
        return 4.0 * T / R;
    }

    public String random6() {
        Random random = new Random();
        Set<Integer> treeSet = new TreeSet<>();
        while (treeSet.size() < 6) {
            treeSet.add(1 + random.nextInt(48));
        }

        Log.d(MainActivity.TAG, "random6: list:" + treeSet);
        return "";
    }

}

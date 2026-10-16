package com.example.cwiczenia4;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import android.content.Intent;

import androidx.test.core.app.ActivityScenario;

import org.junit.Test;

public class NewtonRaphsonInstrumentedTest {

    @Test
    public void testActivityDisplaysCorrectResult() {
        Intent intent = new Intent(
                androidx.test.core.app.ApplicationProvider.getApplicationContext(),
                NewtonRaphson.class
        );
        intent.putExtra("liczba", 16.0);
        intent.putExtra("precyzja", 0.0001);

        try (ActivityScenario<NewtonRaphson> scenario = ActivityScenario.launch(intent)) {
            scenario.onActivity(activity -> {
                String text = activity.textViewWynik.getText().toString();
                // Sprawdzamy poprawne sformatowane wartości dla liczby 16.0 i jej pierwiastka 4.0
                assertTrue(text.contains("Liczba: 16.00"));
                assertTrue(text.contains("precyzja: 0.0001000"));
                assertTrue(text.contains("pierwiastek: 4.0000"));
            });
        }
    }

    @Test
    public void testActivityWithoutExtras_logsHandledGracefully() {
        Intent intent = new Intent(
                androidx.test.core.app.ApplicationProvider.getApplicationContext(),
                NewtonRaphson.class
        );

        try (ActivityScenario<NewtonRaphson> scenario = ActivityScenario.launch(intent)) {
            scenario.onActivity(activity -> {
                assertNotNull(activity.textViewWynik);
            });
        }
    }
}
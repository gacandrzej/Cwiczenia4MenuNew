package com.example.cwiczenia4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class AlgorithmsTest {
    private Algorithms algorithms;

    @Before
    public void setUp() {
        algorithms = new Algorithms();
    }

    @After
    public void tearDown() throws Exception {
        algorithms=null;
    }

    @Test
    public void testNewtonRaphson_basicSquareRoot() {
        double result = algorithms.newtonRaphson(25.0, 0.0001);
        assertEquals(5.0, result, 0.001);
    }

    @Test
    public void testNewtonRaphson_smallNumber() {
        double result = algorithms.newtonRaphson(0.01, 0.000001);
        assertEquals(0.1, result, 0.001);
    }

    @Test
    public void testNewtonRaphson_precisionEffect() {
        double result1 = algorithms.newtonRaphson(9, 0.01);
        double result2 = algorithms.newtonRaphson(9, 0.000001);
        assertEquals(3.0, result1, 0.01);
        assertEquals(3.0, result2, 0.001);
    }

    @Test
    public void testMonteCarlo_piApproximation() {
        double result = algorithms.monteCarlo(1_000_000);
        assertTrue(result > 3.0 && result < 3.3);
    }

    @Test
    public void testRandom6_uniqueNumbers() {
        String output = algorithms.random6();
        assertNotNull(output);
    }

    @Test
    public void testCountingSort_returnsSortedList() {
        List<Integer> input = Arrays.asList(5, 2, 1, 3, 2);
        List<Integer> result = algorithms.countingSort(input);

        assertEquals(Arrays.asList(1, 2, 2, 3, 5), result);
    }


}

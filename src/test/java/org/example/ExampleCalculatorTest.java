package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExampleCalculatorTest {

    @Test
    void testSumWithPositiveNumbers() {
        assertEquals(5, ExampleCalculator.sum(2, 3), "2 + 3 should equal 5");
    }

    @Test
    void testSumWithNegativeNumbers() {
        assertEquals(-5, ExampleCalculator.sum(-2, -3), "-2 + (-3) should equal -5");
    }

    @Test
    void testSumWithZero() {
        assertEquals(7, ExampleCalculator.sum(7, 0), "7 + 0 should equal 7");
        assertEquals(-3, ExampleCalculator.sum(0, -3), "0 + (-3) should equal -3");
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0, 0",
            "1, 1, 2",
            "-1, 1, 0",
            "5, -3, 2",
            "10, 20, 30"
    })
    void testSumWithVariousInputs(int first, int second, int expected) {
        assertEquals(expected, ExampleCalculator.sum(first, second),
                () -> first + " + " + second + " should equal " + expected);
    }
}

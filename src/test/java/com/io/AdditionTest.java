package com.io;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdditionTest {
    MathTest mathTest;

    public AdditionTest() {
        System.out.println("Test Class Instance created");
    }

    @BeforeEach
    public void beforeEach() {
        mathTest = new MathTest();
        System.out.println("Before Each Test Execution");
    }
    @AfterEach
    public void afterEach() {
        System.out.println("After Each Test Execution");
    }
    @Test
    void add() {
        int actual = mathTest.add(33, 44);
        int expected = 77;
        assertEquals(expected, actual, "addition is a+b");
    }

    @Test
    void computeCircleArea() {
        double actual = Math.PI * 10 * 10;
        double expected = mathTest.computeCircleArea(10);
        assertEquals(actual, expected);

    }
}
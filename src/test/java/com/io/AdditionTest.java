package com.io;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.JRE;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class AdditionTest {
    /*
     *
     * There can be any number of @BeforeEach,@AfterEach, @BeforeAll, @AfterAll annotated methods.And they are going to run
     * randomly on their own.
     */
    MathTest mathTest;

    public AdditionTest() {
        //For Each Test Method a new Instance of AdditionTest is created every time for Every method
        System.out.println("Test Class Instance created");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before All created Here");
    }

    @BeforeEach
    public void beforeEach() {
        mathTest = new MathTest();
        System.out.println("Before Each Test Execution");
    }

    @BeforeEach
    public void beforeEach2() {
        mathTest = new MathTest();
        System.out.println("Before Each2 Test Execution");
    }

    @AfterEach
    public void afterEach() {
        /* Runtime.getRuntime().gc();*/
        System.gc();
        System.out.println("Garbage Collection After Each Test Execution");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("After All Executed");
    }

    @Nested
    class addTest {// Nested class Test are just for grouping same kind of tests together
        @Test
        @DisplayName("addition of + numbers")
        void addPositive() {
            assertEquals(77, mathTest.add(33, 44), "addition is a+b");
        }

        @Test
        @DisplayName("addition of - numbers")
        void addNegative() {
            assertEquals(77, mathTest.add(-23, 100), "addition is -a+b");
        }
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_11)
    void computeCircleArea() {
        boolean isDbConnected = true;
        assumeTrue(isDbConnected);
        double actual = Math.PI * 10 * 10;
        double expected = mathTest.computeCircleArea(10);
        assertEquals(actual, expected);

    }

}
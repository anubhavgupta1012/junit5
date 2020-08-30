package com.io;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    /*@Test
    @DisplayName("add 2 number Test")
    @EnabledOnOs(OS.WINDOWS)
    void add() {
        int actual = mathTest.add(33, 44);
        int expected = 77;
        assertEquals(expected, actual, "addition is a+b");
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_11)
    void computeCircleArea() {
        boolean isDbConnected = false;
        assumeTrue(isDbConnected);
        double actual = Math.PI * 10 * 10;
        double expected = mathTest.computeCircleArea(10);
        assertEquals(actual, expected);

    }*/

    @Test
    public void testAll() {
        assertAll(
                () -> assertEquals(Math.PI * 10 * 10, mathTest.computeCircleArea(10)),
                () -> assertEquals(77, mathTest.add(33, 44))
        );
    }

}
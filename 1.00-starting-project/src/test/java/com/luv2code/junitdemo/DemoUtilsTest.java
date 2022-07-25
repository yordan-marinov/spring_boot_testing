package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


//@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
//@TestMethodOrder(MethodOrderer.DisplayName.class)
class DemoUtilsTest {

    DemoUtils demoUtils;

//    @BeforeAll
//    static void beforeAll() {
//        System.out.println("Executing @BeforeAll\n");
//    }
//
//    @AfterAll
//    static void afterAll() {
//        System.out.println("Executing @AfterAll ");
//    }

    @BeforeEach
    void setUp() {
        demoUtils = new DemoUtils();
    }

//    @AfterEach
//    void tearDown() {
//        System.out.println("Executing @AfterEach\n");
//    }

    @Test
    void testEqualAndNotEquals() {
        int actual = demoUtils.add(2, 4);
        int expected = 6;

        assertEquals(expected, actual, "2 + 4 must be 6");
        assertNotEquals(7, actual, "2 + 4 must be 6");

    }

    @Test
    void getAcademyInList() {
        List<String> expected = List.of("luv", "2", "code");
        List<String> actual = demoUtils.getAcademyInList();

        assertIterableEquals(expected, actual, "The lists should be hold equal values");
    }

    @Test
    void getLinesMatch() {
        List<String> expected = List.of("luv", "2", "code");
        List<String> actual = demoUtils.getAcademyInList();

        assertLinesMatch(expected, actual, "The lines should match");
    }

    @Test
    void getAcademy() {
        String actual = demoUtils.getAcademy();
        String duplicate = demoUtils.getAcademyDuplicate();

        assertSame(actual, duplicate, "Object should refer to the same object");
        assertNotSame("Demo test", actual, "Object should Not refer to the same object");
    }

    @Test
    void getAcademyDuplicate() {
        String actual = demoUtils.getAcademyDuplicate();

        assertSame(demoUtils.getAcademy(), actual, "Should refer to the same object");
        assertNotSame("This is not the same obj", actual, "Should not refer the same object");
    }

    @Test
    void getFirstThreeLettersOfAlphabet() {
        String[] actual = demoUtils.getFirstThreeLettersOfAlphabet();
        String[] expected = {"A", "B", "C"};

        assertArrayEquals(expected, actual, "The arrays should be equal values");
        assertNotEquals(expected, actual, "The object should not refer to the same object");
    }

    @Test
    void add() {
        assertEquals(6, demoUtils.add(3, 3), "Should return there are equal");
    }

    @Test
    void multiply() {
        int expected = 9;
        int actual = demoUtils.multiply(3, 3);

        assertEquals(expected, actual, "result must be 9");
        assertNotEquals(6, actual, "result must be 9 and not 6");
    }

    @Test
    void checkNull() {
        Object str1 = null;
        String str2 = "Hello test";

        assertNull(demoUtils.checkNull(str1), "Obj Must be null");
        assertNotNull(demoUtils.checkNull(str2), "Obj Must not be null");
    }

    @Test
    void isGreater() {
        int gradeOne = 10;
        int gradeTwo = 5;

        assertTrue(demoUtils.isGreater(gradeOne, gradeTwo));
    }

    @Test
    void isNotGreater() {
        int gradeOne = 5;
        int gradeTwo = 10;

        assertFalse(demoUtils.isGreater(gradeOne, gradeTwo));
    }

    @Test
    void throwAndNotThrowException() {
        assertThrows(Exception.class, () -> demoUtils.throwException(-1), "Should throw exception when number is negative");
        assertDoesNotThrow(() -> demoUtils.throwException(1), "Should not throw exception when number is positive");
    }

    @Test
    void checkTimeout() {
        assertTimeoutPreemptively(Duration.ofMillis(2010), () -> demoUtils.checkTimeout(), "Method should execute in more than 2 seconds");
    }
}
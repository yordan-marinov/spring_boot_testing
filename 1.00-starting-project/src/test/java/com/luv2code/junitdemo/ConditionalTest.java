package com.luv2code.junitdemo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.Assertions.*;


public class ConditionalTest {

    @Test
    @Disabled("Don't run until JIRA mr1344 is fixed")
    void basicTest() {
        // execute method and perform asserts
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testForWindowsOnly() {
        // execute method and perform asserts
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void testForMacOnly() {
        // execute method and perform asserts
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void testForLinux() {
        // execute method and perform asserts
        assertEquals(OS.current(), OS.LINUX);
    }

    @Test
    @EnabledOnOs({OS.LINUX, OS.MAC})
    void testForLinuxAndMac() {
        // execute method and perform asserts
        assertEquals(OS.current(), OS.LINUX);
        assertNotEquals(OS.current(), OS.MAC);
    }

    @Test
    @EnabledOnJre(JRE.JAVA_17)
    void testForJava17() {
        // execute method and perform asserts

        assertEquals(JRE.currentVersion(), JRE.JAVA_17);
    }

    @Test
    @EnabledOnJre(JRE.JAVA_13)
    void testForJava11() {
        // execute method and perform asserts

//        assertNotEquals(JRE.currentVersion(), JRE.JAVA_17);
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "LOCAL-DEV", matches = "DEV") // LOCAL-DEV=DEV
    void testForDevEnvironment() {
        // execute method and perform asserts

        assertEquals(JRE.currentVersion(), JRE.JAVA_17);
    }

    @Test
    @EnabledIfSystemProperty(named = "SYS-PROP", matches = "CI-CD-DEPLOY")  // -ea -DSYS-PROP=CI-CD-DEPLOY
    void testForSystemProperty() {
        // execute method and perform asserts

        assertEquals(JRE.currentVersion(), JRE.JAVA_17);
    }
}

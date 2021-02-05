package com.example.week2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    //Test that username is created correctly
    @Test
    public void checkUsername() {
        String username = "test";
        Users testUser = new Users(0, username, "password");
        assertEquals(testUser.getUsername(), username);
    }

    //Test that password is created correctly
    @Test
    public void checkPassword() {
        String password = "password";
        Users testUser = new Users(0, "test", password);
        assertEquals(testUser.getPassword(), password);
    }
}
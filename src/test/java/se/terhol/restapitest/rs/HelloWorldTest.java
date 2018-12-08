package se.terhol.restapitest.rs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Tereza Holm
 */
class HelloWorldTest {
    @Test
    void getMessage() {
        assertEquals("Hello world!", "Hello world!");
    }
}
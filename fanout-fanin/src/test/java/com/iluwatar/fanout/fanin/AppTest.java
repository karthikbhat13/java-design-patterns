package com.iluwatar.fanout.fanin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class AppTest {

    @Test
    void shouldLaunchApp() {
        assertDoesNotThrow(() -> App.main(new String[]{}));
    }
}

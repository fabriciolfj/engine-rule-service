package com.github.fabriciolfj.engineruleservice;

import com.github.fabriciolfj.engineruleservice.exceptions.enums.Errors;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ErrosTest {

    @Test
    void testGetMessageError() {
        var msg = Errors.ERROR_01.getMessage();
        
        assertNotNull(msg);
    }
}

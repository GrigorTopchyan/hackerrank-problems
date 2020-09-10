package edu.traning.hackerrank.algorithms_datastructures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryGapTest {

    @DisplayName("When findBinaryGap then maximum binary gap should be returned")
    @Test
    void testBinaryGap(){
        assertEquals(5,BinaryGap.findBinaryGap(1041));
        assertEquals(0,BinaryGap.findBinaryGap(32));
        assertEquals(0,BinaryGap.findBinaryGap(1));
        assertEquals(1,BinaryGap.findBinaryGap(5));
    }
}
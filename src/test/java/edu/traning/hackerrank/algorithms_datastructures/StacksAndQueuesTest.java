package edu.traning.hackerrank.algorithms_datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StacksAndQueuesTest {

    @Test
    void brackets() {
        Assertions.assertEquals(1,StacksAndQueues.brackets("{[()()]}"));
        Assertions.assertEquals(0,StacksAndQueues.brackets(")("));
    }
}
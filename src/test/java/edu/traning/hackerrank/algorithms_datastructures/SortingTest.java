package edu.traning.hackerrank.algorithms_datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortingTest {

    @Test
    void distinct() {
    }

    @Test
    void maxTriplet() {
    }

    @Test
    void numberOfDistinctIntersections() {
//        int [] arr = new int[]{1,5,2,1,4,0};
//        Assertions.assertEquals(11,Sorting.numberOfDistinctIntersections(arr));

        int [] arr1 = new int[]{1,2147483647,0};
        Assertions.assertEquals(2,Sorting.numberOfDistinctIntersections(arr1));
    }
}
package edu.traning.hackerrank.algorithms_datastructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraysUtilsTest {

    @Test
    void rotateArray() {
        int [] arr = {3, 8, 9, 7, 6};
        ArraysUtils.rotateArray(arr, 3);
        int [] expected = {9, 7, 6, 3, 8};
        assertArrayEquals(expected, arr);
    }

    @Test
    void sortedArrayContainsPairsWithSum() {
    }

    @Test
    void oddOccurrences() {
        int [] arr = {1,1,2,2,3,3,4,4,5,5,6};
        assertEquals(6, ArraysUtils.oddOccurrences(arr));
    }

    @Test
    void missingElement() {
        int[] arr = {1,2,3,5,6};
        assertEquals(4,ArraysUtils.missingElement(arr));
    }

    @Test
    void tapeEquilibrium() {
        int [] arr = {3,1,2,4,3};
        assertEquals(1,ArraysUtils.tapeEquilibrium(arr));
    }

    @Test
    void maxCounters() {
        int [] arr = {3,4,4,6,1,4,4};
        int [] expected = {3,2,2,4,2};
        assertArrayEquals(expected,ArraysUtils.maxCounters(5,arr));
    }

    @Test
    void missingInteger() {
        int [] arr = {1,3,6,4,1,2};
        assertEquals(5,ArraysUtils.missingInteger(arr));
    }

    @Test
    void permCheck() {
        int [] arr = {4,1,3,2};
        assertEquals(0,ArraysUtils.permCheck(arr));
        int [] arr1 = {4,1,3};
        assertEquals(1,ArraysUtils.permCheck(arr1));
    }

    @Test
    void containsPairsWithSum() {
        int [] arr = {3,1,2,4};
        assertTrue(ArraysUtils.containsPairsWithSum(arr,8));
    }
}
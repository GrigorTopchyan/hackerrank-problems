package edu.traning.hackerrank.algorithms_datastructures;

import java.util.*;
import java.util.stream.Collectors;

public class PrefixSum {
    public int countDiv(int a, int b, int k) {
        int aDivK = a / k;
        int bDivK = b / k;
        int res = bDivK - aDivK;
        if (a % k == 0) {
            res++;
        }

        return res;
    }

    public int[] genomicRangeQuery(String s, int[] p, int[] q) {
        int[][] factorCounts = new int[4][s.length()];
        factorCounts[map(s.charAt(0))][0] = 1;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < 4; j++) {
                if (j == map(s.charAt(i))) {
                    factorCounts[j][i] = factorCounts[j][i - 1] + 1;
                } else {
                    factorCounts[j][i] = factorCounts[j][i - 1];
                }
            }

        }

        int[] result = new int[p.length];
        for (int i = 0; i < p.length; i++) {
            int start = p[i];
            int end = q[i];
            for (int j = 0; j < 4; j++) {
                if (factorCount(factorCounts, start, end, j) != 0) {
                    result[i] = j + 1;
                    break;
                }
            }
        }

        return result;
    }

    private int factorCount(int[][] arr, int start, int end, int j) {
        if (start == 0) {
            return arr[j][end];
        } else {
            return arr[j][end] - arr[j][start - 1];
        }
    }

    private int map(char ch) {
        if (ch == 'A') return 0;
        if (ch == 'C') return 1;
        if (ch == 'G') return 2;
        return 3;
    }

    public int minAvgTwoSlice(int[] arr) {
        int startingPosition = 0;
        double min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            double avgSlice = (arr[i] + arr[i + 1]) / 2.0;
            if (Double.compare(avgSlice, min) < 0) {
                min = avgSlice;
                startingPosition = i;
            }
            if (i + 2 < arr.length) {
                avgSlice = (arr[i] + arr[i + 1] + arr[i + 2]) / 3.0;
                if (Double.compare(avgSlice, min) < 0) {
                    min = avgSlice;
                    startingPosition = i;
                }
            }
        }

        return startingPosition;

    }

}
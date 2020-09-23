package edu.traning.hackerrank.algorithms_datastructures;

import edu.traning.hackerrank.common.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;

public class Sorting {

    /**
     Write a function

     class Solution { public int solution(int[] A); }

     that, given an array A consisting of N integers, returns the number of distinct values in array A.

     For example, given array A consisting of six elements such that:
     A[0] = 2    A[1] = 1    A[2] = 1
     A[3] = 2    A[4] = 3    A[5] = 1

     the function should return 3, because there are 3 distinct values appearing in array A, namely 1, 2 and 3.

     Write an efficient algorithm for the following assumptions:

     N is an integer within the range [0..100,000];
     each element of array A is an integer within the range [−1,000,000..1,000,000].
     */
    public static int distinct(int[] arr){
        return Set.of(arr).size();
    }

    /**
     *
     A non-empty array A consisting of N integers is given. The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).

     For example, array A such that:
     A[0] = -3
     A[1] = 1
     A[2] = 2
     A[3] = -2
     A[4] = 5
     A[5] = 6

     contains the following example triplets:

     (0, 1, 2), product is −3 * 1 * 2 = −6
     (1, 2, 4), product is 1 * 2 * 5 = 10
     (2, 4, 5), product is 2 * 5 * 6 = 60

     Your goal is to find the maximal product of any triplet.

     Write a function:

     class Solution { public int solution(int[] A); }

     that, given a non-empty array A, returns the value of the maximal product of any triplet.

     For example, given array A such that:
     A[0] = -3
     A[1] = 1
     A[2] = 2
     A[3] = -2
     A[4] = 5
     A[5] = 6

     the function should return 60, as the product of triplet (2, 4, 5) is maximal.

     Write an efficient algorithm for the following assumptions:

     N is an integer within the range [3..100,000];
     each element of array A is an integer within the range [−1,000..1,000].
     */
    public static int maxTriplet(int [] arr){
        int l = arr.length - 1;
        Arrays.sort(arr);
        return Math.max(arr[0] * arr[1] * arr[l], arr[l] * arr[l-1] * arr[l-2]);
    }

    /**
     We draw N discs on a plane. The discs are numbered from 0 to N − 1. An array A of N non-negative integers, specifying the radiuses of the discs, is given. The J-th disc is drawn with its center at (J, 0) and radius A[J].
     We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and K-th discs have at least one common point (assuming that the discs contain their borders).

     The figure below shows discs drawn for N = 6 and A as follows:
     A[0] = 1
     A[1] = 5
     A[2] = 2
     A[3] = 1
     A[4] = 4
     A[5] = 0

     There are eleven (unordered) pairs of discs that intersect, namely:

     discs 1 and 4 intersect, and both intersect with all the other discs;
     disc 2 also intersects with discs 0 and 3.

     Write a function:

     class Solution { public int solution(int[] A); }

     that, given an array A describing N discs as explained above, returns the number of (unordered) pairs of intersecting discs. The function should return −1 if the number of intersecting pairs exceeds 10,000,000.

     Given array A shown above, the function should return 11, as explained above.

     Write an efficient algorithm for the following assumptions:

     N is an integer within the range [0..100,000];
     each element of array A is an integer within the range [0..2,147,483,647].
     */
    public static int numberOfDistinctIntersections(int [] arr){
        Pair<Integer,Integer> [] coordinates = new Pair[arr.length];
        for (int i = 0; i < arr.length; i++) {
            coordinates[i] = new Pair<>(checkLowerOverflow(i, arr[i]),checkUpperOverflow(i , arr[i]));
        }
        int result = 0;
        Arrays.sort(coordinates, Comparator.comparing(p -> p.first));
        for (int i = 0; i < coordinates.length; i++) {
            int j = i + 1;
            while (j < coordinates.length && coordinates[j].first <= coordinates[i].second){
                result++;
                j++;
            }
        }
        return result;
    }

    private static int checkLowerOverflow(int i, int number){
        return i - Integer.MIN_VALUE < number ? i - number: Integer.MIN_VALUE;
    }


    private static int checkUpperOverflow(int i, int number){
        return Integer.MAX_VALUE - i > number ? i + number : Integer.MAX_VALUE;
    }

    /**
     *

     An array A consisting of N integers is given. A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:

     A[P] + A[Q] > A[R],
     A[Q] + A[R] > A[P],
     A[R] + A[P] > A[Q].

     For example, consider array A such that:
     A[0] = 10    A[1] = 2    A[2] = 5
     A[3] = 1     A[4] = 8    A[5] = 20

     Triplet (0, 2, 4) is triangular.

     Write a function:

     class Solution { public int solution(int[] A); }

     that, given an array A consisting of N integers, returns 1 if there exists a triangular triplet for this array and returns 0 otherwise.

     For example, given array A such that:
     A[0] = 10    A[1] = 2    A[2] = 5
     A[3] = 1     A[4] = 8    A[5] = 20

     the function should return 1, as explained above. Given array A such that:
     A[0] = 10    A[1] = 50    A[2] = 5
     A[3] = 1

     the function should return 0.

     Write an efficient algorithm for the following assumptions:

     N is an integer within the range [0..100,000];
     each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
     */
    public int isExistsTriangle(int [] arr){
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i]  > arr[i+2] - arr[i+1]){
                return 1;
            }
        }

        return 0;
    }
}

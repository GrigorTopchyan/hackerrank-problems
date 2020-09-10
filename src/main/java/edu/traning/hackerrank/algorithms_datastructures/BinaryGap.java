package edu.traning.hackerrank.algorithms_datastructures;

/**
 * A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.
 */
public class BinaryGap {
    public static int findBinaryGap(int N){
        String binaryN = trim0(Integer.toBinaryString(N));
        if (binaryN.isEmpty() || binaryN.length() < 3){
            return 0;
        }

        int max = 0;
        int tempMax = 0;
        for (int i = 1; i < binaryN.length(); i++) {
            if (binaryN.charAt(i) == '0'){
              tempMax++;
            }else {
                if (tempMax > max){
                    max = tempMax;
                }
                tempMax = 0;
            }
        }

        return max;
    }
    private static String trim0(String binaryNumber){
        int start = 0;
        int end = binaryNumber.length() - 1;

        while (start <= end && binaryNumber.charAt(start) == '0'){
            start--;
        }

        while (end > start && binaryNumber.charAt(end) == '0'){
            end--;
        }

        return binaryNumber.substring(start,end+1);
    }
}

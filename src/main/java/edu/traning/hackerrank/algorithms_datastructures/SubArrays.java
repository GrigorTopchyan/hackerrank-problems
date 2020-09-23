package edu.traning.hackerrank.algorithms_datastructures;

import edu.traning.hackerrank.common.Pair;

import java.util.*;

public class SubArrays {
    public static int longestSubarray(List<Integer> arr) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int max = Integer.MIN_VALUE;
        if (arr.size() == 0 ){
            return 0;
        }

        Pair<Integer,Integer> previous = new Pair<>(arr.get(0),1);

        for (int i : arr) {

            map.merge(i, 1, Integer::sum);
            if (map.size() > 2) {
                map.remove(previous);
            } else if (map.size() == 2) {
                Iterator<Integer> iterator = map.keySet().iterator();
                int k1 = iterator.next();
             //   previous = k1;
                int k2 = iterator.next();
                if (Math.abs(k1 - k2) == 1 && max < map.get(k1) + map.get(k2)) {
                    max = map.get(k1) + map.get(k2);
                }
            }

        }

        int sum = map.values().stream().mapToInt(i -> i).sum();
        if( max < sum && map.size() < 2)
            max = sum;

        return max;
    }


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(longestSubarray(list));
    }
}

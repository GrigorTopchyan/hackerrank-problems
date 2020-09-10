package test;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution1 {
    public int solution(String S, int K) {
       int min = Integer.MAX_VALUE;
        char[] chars = S.toCharArray();
        for (int i = 0; i + K < chars.length; i++) {
            int length = compressedLength(chars, i, K);
            if(min > length){
                min = length;
            }
        }
        return min;
    }
    
    private int compressedLength(char [] s, int start, int k){
        char ch = s[0];
        if (start == 0){
            ch = s[k];
        }

        StringBuilder result = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            if (i >= start && i < start + k){
                continue;
            }
            if (s[i] == ch){
                count++;
            }else {
                if (count > 1) {
                    result.append(count);
                }
                result.append(ch);
                ch = s[i];
                count= 1;
            }
            
            if (i == s.length-1){
                if (count > 1) {
                    result.append(count);
                }
                result.append(ch);
                ch = s[i];
                count= 1;
            }
        }
        
        return result.length();
    }

    public static void main(String[] args) {
        String s = "ABBBCCDDCCC";
        System.out.println(new Solution1().solution(s,3));
    }
}

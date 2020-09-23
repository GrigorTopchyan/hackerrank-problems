package edu.traning.hackerrank.algorithms_datastructures;

import java.util.LinkedList;

public class StacksAndQueues {

    /**
     * A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:
     * <p>
     * S is empty;
     * S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
     * S has the form "VW" where V and W are properly nested strings.
     * <p>
     * For example, the string "{[()()]}" is properly nested but "([)()]" is not.
     * <p>
     * Write a function:
     * <p>
     * class Solution { public int solution(String S); }
     * <p>
     * that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.
     * <p>
     * For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.
     * <p>
     * Write an efficient algorithm for the following assumptions:
     * <p>
     * N is an integer within the range [0..200,000];
     * string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
     */
    public static int brackets(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{') {
                stack.push('}');
            } else if (c == '(') {
                stack.push(')');
            } else  if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty()) {
                return 0;
            } else {
                if (stack.pop() != c){
                    return 0;
                }
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}

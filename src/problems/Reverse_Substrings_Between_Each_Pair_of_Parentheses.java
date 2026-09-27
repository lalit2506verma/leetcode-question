package problems;

import java.util.Stack;

public class Reverse_Substrings_Between_Each_Pair_of_Parentheses {
    public static void main(String[] args) {

    }

    public String reverseParentheses(String s) {
        int n = s.length();
        int[] matchIdx = new int[n];
        Stack <Integer> stack = new Stack<>();

        // Linking the parenthesis to each other
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }
            else{
                matchIdx[i] = stack.pop();
                matchIdx[matchIdx[i]] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        int dir = 1;
        for(int i = 0; i < n; i += dir){
            if(s.charAt(i) >= 'a'){
                sb.append(s.charAt(i));
            }
            else{
                // go to matching parenthesis and change direction
                i = matchIdx[i];
                dir = -dir;
            }
        }

        return sb.toString();
    }
}

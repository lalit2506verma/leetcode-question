package problems;

import java.util.Arrays;

public class Minimum_Operations_to_Transform_String {
    public static void main(String[] args) {
        String s = "cda";
        System.out.println(minOperations(s));
    }

    public static int minOperations(String s) {
        int maxSteps = 0;

        for(char c : s.toCharArray()){
            if(c == 'a'){
                continue;
            }
            // circle back
            int currectSteps = 26 - (c - 'a');

            maxSteps = Math.max(maxSteps, currectSteps);
        }

        return maxSteps;
    }
}

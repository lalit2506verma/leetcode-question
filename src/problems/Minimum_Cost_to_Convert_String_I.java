package problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Minimum_Cost_to_Convert_String_I {
    static int[][] matrix = new int[26][26];

    public static void main(String[] args) {
        char[] original = {'a','b','c','c','e','d'};
        char[] changed = {'b','c','b','e','b','e'};
        int[] cost = {2,5,5,1,2,20};

        System.out.println(minimumCost("abcd", "acbe", original, changed, cost));
    }

    public static long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        for(int i = 0; i < 26; i++){
            for(int j = 0; j < 26; j++){
                if(i == j) matrix[i][j] = 0;
                else matrix[i][j] = Integer.MAX_VALUE;
            }
        }

        // add existing path values
        for(int i = 0; i < original.length; i++){
            int src =  original[i] - 'a';
            int dst = changed[i] - 'a';

            matrix[src][dst] = cost[i];
        }

        // floydMarshall
        shortestPathCalc();

        long minCost = 0;
        for(int i = 0; i < source.length(); i++){
            int src =   source.charAt(i) - 'a';
            int dst = target.charAt(i) - 'a';
            if(matrix[src][dst] != Integer.MAX_VALUE){
                minCost += matrix[src][dst];
            }
            else{
                return -1;
            }
        }

        return minCost;
    }

    private static void shortestPathCalc() {
        for(int via = 0; via < 26; via++){
            for(int i = 0; i < 26; i++){
                for(int j = 0; j < 26; j++){
                    if(matrix[i][via] != Integer.MAX_VALUE && matrix[via][j] != Integer.MAX_VALUE){
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][via] + matrix[via][j]);
                    }
                }
            }
        }
    }

}

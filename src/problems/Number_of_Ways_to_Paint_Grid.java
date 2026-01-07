package problems;

import java.util.Arrays;

public class Number_of_Ways_to_Paint_Grid {
    public static void main(String[] args) {

    }

    static String[] pattern = {"RYR","YRY","GRY","RYG","YRG","GRG","RGR","YGR","GYR","RGY","YGY","GYG"};
    static int MOD = 1_000_000_007;

    public int numOfWays(int n) {
        if(n == 1) return pattern.length;
        int result = 0;

        int[][] dp = new int[n][12];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        for(int i = 0; i < 12; i++){
            result += helper(n - 1, i, dp) % MOD;
        }

        return result;
    }

    public int helper(int n, int i, int[][] dp){
        if(n == 0){
            return 1;
        }

        if(dp[n][i] != -1) return dp[n][i];

        String prev = pattern[i];
        int result = 0;
        for(int j = 0; j < 12; j++){
            if(i == j){
                continue;
            }

            String currPattern = pattern[j];
            boolean flag = false;
            for(int col = 0; col < 3; col++){
                if(prev.charAt(col) == currPattern.charAt(col)){
                    flag = true;
                    break;
                }
            }

            if(!flag){
                result = (result + helper(n-1, j, dp))% MOD;
            }
        }

        return dp[n][i] = result;
    }
}

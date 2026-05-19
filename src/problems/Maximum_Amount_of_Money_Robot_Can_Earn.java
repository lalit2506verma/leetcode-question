package problems;

import java.util.Arrays;

public class Maximum_Amount_of_Money_Robot_Can_Earn {
    static int n, m;
    public static void main(String[] args) {
        int[][] coins =  {{0,1,-1}, {1,-2,3}, {2,-3,4}};
        System.out.println(maximumAmount(coins));
    }

    public static int maximumAmount(int[][] coins) {
        n = coins.length;
        m = coins[0].length;
        int[][][] dp = new int[n][m][3];
        for (int[][] row : dp) {
            for (int[] col : row) {
                Arrays.fill(col, Integer.MIN_VALUE);
            }
        }

        return maxAmount(coins, 0, 0, 2, dp);
    }

    private static int maxAmount(int[][] coins, int i, int j, int neutralize, int[][][] dp) {
        // out of index case
        if(i >= n || j >= m) return 0;

        // targetReached
        if(i == n-1 && j == m-1){
            if(neutralize > 0 && coins[i][j] < 0){
                return 0;
            }
            return coins[i][j];
        }

        if(dp[i][j][neutralize] != Integer.MIN_VALUE){
            return dp[i][j][neutralize];
        }

        int amount = coins[i][j];
        int best = Integer.MIN_VALUE;
        // if neutralize if negative
        if(coins[i][j] < 0 && neutralize > 0){
            best = Math.max(best, Math.max(maxAmount(coins, i+1, j, neutralize-1, dp),
                    maxAmount(coins, i, j+1, neutralize-1, dp)));
        }

        // take the value as it is
        best = Math.max(best, Math.max(maxAmount(coins, i+1, j, neutralize, dp),
                maxAmount(coins, i, j+1, neutralize, dp)));

        return dp[i][j][neutralize] = (amount < 0 && neutralize > 0 ? 0 : amount) + best;
    }
}

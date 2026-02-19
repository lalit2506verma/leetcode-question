package problems;

import java.util.Arrays;

public class Minimum_Cost_Path_with_Teleportation {
    static int n, m;
    public static void main(String[] args) {
        int[][] grid = {{1,3,3}, {2,5,4}, {4,3,5}};
        System.out.println(minCost(grid, 2));
    }

    public static int minCost(int[][] grid, int k) {
        n = grid.length;
        m = grid[0].length;

        int[][] dp = new int[n][m];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return Math.min(helper(grid, 1, 0, dp),  helper(grid, 0, 1, dp));
    }

    private static int helper(int[][] grid, int i, int j, int[][] dp) {
        if(i >= n || j >= m) return Integer.MAX_VALUE;

        if( i == n-1 && j == m-1){
            return grid[i][j];
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        // Normal Move
        int rightCost = helper(grid, i, j+1, dp);
        int downCost = helper(grid, i+1, j, dp);

        return dp[i][j] = grid[i][j] + Math.min(rightCost, downCost);
    }
}

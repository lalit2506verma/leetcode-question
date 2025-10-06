package problems;

import java.util.ArrayList;

public class Swim_in_Rising_Water {
    static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    static int n;
    public static void main(String[] args) {
        int[][] grid = {{0,2},{1,3}};
        System.out.println(swimInWater(grid));

    }

    public static int swimInWater(int[][] grid) {
        n = grid.length;
        int l = grid[0][0];
        int r = (int) Math.pow(n, 2) - 1;

        int res = 0;

        while(l <= r){
            int mid = l + (r - l) / 2;

            boolean[][] visited = new boolean[n][n];
            if(possiblePath(grid, mid, 0, 0, visited)){
                res = mid;
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }

        return res;

    }

    // DFS
    private static boolean possiblePath(int[][] grid, int mid, int i, int j, boolean[][] visited ) {
        // Out-of-bound and mid should not be less than grid[i][j]

        if( i < 0 || i >= n || j < 0 || j >= n || mid < grid[i][j] || visited[i][j]){
            return false;
        }

        visited[i][j] = true;

        if( i == n-1 && j == n-1){
            return true;
        }

        for(int[] dir : directions){
            int i_ = i + dir[0];
            int j_ = j + dir[1];

            if(possiblePath(grid, mid, i_, j_, visited)){
                return true;
            }
        }

        return false;
    }
}

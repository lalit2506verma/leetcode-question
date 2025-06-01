package problems;

import java.util.Arrays;

public class FindBuildingAliceAndBob {
    public static void main(String[] args) {
        int[] arr = {6,4,8,5,2,7};
        int[][] qu = {{0,1},{0,3},{2,4},{3,4},{2,2}};


        System.out.println(Arrays.toString(leftmostBuildingQueries(arr, qu)));
    }

    public static int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int[] ans = new int[queries.length];

        for(int i = 0; i < queries.length; i++){
            int x  = queries[i][0];
            int y = queries[i][1];
            // if x <= y and height[y] > height[x]
            if(x <= y && heights[x] <= heights[y]){
                ans[i] = heights[y];
            }
            else if(x < y && heights[x] > heights[y]){
                ans[i] = findLeftMost(heights, y, heights[x]);
            }
            else if(x > y && heights[x] > heights[y]){
                ans[i] = findLeftMost(heights, x, heights[x]);
            }
            else{
                ans[i] = findLeftMost(heights, x, heights[y]);
            }

        }
        return ans;
    }

    public static int findLeftMost(int[] heights, int y, int max){
        for(int i = y+1; i < heights.length; i++){
            if(max < heights[i]){
                return i;
            }
        }

        return -1;
    }
}

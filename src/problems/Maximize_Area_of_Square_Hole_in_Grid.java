package problems;

import java.util.Arrays;

public class Maximize_Area_of_Square_Hole_in_Grid {
    public static void main(String[] args) {
        int[] hBars = {4,2};
        int[] vBars = {3,2};
        System.out.println(maximizeSquareHoleArea(4,2, hBars,vBars));
    }

    public static int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int hMax = longestConsecutive(hBars);
        int vMax = longestConsecutive(vBars);

        int longestSide = Math.min(hMax+1, vMax+1);

        return longestSide * longestSide;
    }

    private static int longestConsecutive (int[] arr) {
        int maxLen = -1;
        int len = 1;

        for(int i = 1; i < arr.length; i++){
            if(arr[i-1] == arr[i] - 1){
                len++;
            }
            else{
                maxLen = Math.max(maxLen, len);
                len = 1;
            }
        }
        maxLen = Math.max(maxLen, len);
        return maxLen;
    }
}

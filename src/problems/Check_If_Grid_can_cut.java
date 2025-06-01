package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Check_If_Grid_can_cut {
    public static void main(String[] args) {
        int[][] rec = {{1,0,5,2},{0,2,2,4},{3,2,5,3},{0,4,4,5}};

        System.out.println(checkValidCuts(5, rec));
    }

    public static boolean checkValidCuts(int n, int[][] rectangles) {
        int l = rectangles.length;
//        int[][] arrX = new int[l][2];
//        int[][] arrY = new int[l][2];
//
//        for (int i = 0; i < l; i++) {   // [start_X, start_Y, end_X, end_Y]
//            arrX[i][0] = rectangles[i][0];
//            arrX[i][1] = rectangles[i][2];
//
//            arrY[i][0] = rectangles[i][1];
//            arrY[i][1] = rectangles[i][3];
//        }

        return isPossible(rectangles, "X") || isPossible(rectangles, "Y");
    }

    private static boolean isPossible(int[][] arr, String x) {
        List<int[]> intervals = new ArrayList<>();

        if(x.equals("X")){
            Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

            int[] prev = arr[0];

            for (int i = 1; i < arr.length; i++) {
                int[] curr = arr[i];

                if(prev[2] > curr[0]){
                    prev[2] = Math.max(prev[2], curr[2]);
                }
                else{
                    intervals.add(prev);
                    prev = curr;
                }
            }
            // for last element
            intervals.add(prev);
        }
        else{
            Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));

            int[] prev = arr[0];

            for (int i = 1; i < arr.length; i++) {
                int[] curr = arr[i];

                if(prev[3] > curr[1]){
                    prev[3] = Math.max(prev[3], curr[3]);
                }
                else{
                    intervals.add(prev);
                    prev = curr;
                }
            }
            // for last element
            intervals.add(prev);
        }

        return intervals.size() >= 3;
    }
}

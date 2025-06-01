package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge_Interval {
    public static void main(String[] args) {
        int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
        int[][] matrix =  mergeInterval(arr);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] mergeInterval(int[][] arr){
        // sorting
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();

        int[] prev = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int[] curr = arr[i];

            if(prev[1] > curr[0]){
                prev[1] = Math.max(prev[1], curr[1]);
            }
            else{
                res.add(prev);
                prev = curr;
            }
        }

        // for last element
        res.add(prev);

        return res.toArray(new int[res.size()][]);
    }
}

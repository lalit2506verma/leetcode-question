package problems;

import java.util.Arrays;
import java.util.Collections;

public class Largest_Submatrix_With_Rearrangements {
    public static void main(String[] args) {
        int[][] matrix = {
                {0,0,1},
                {1,1,1},
                {1,0,1}
        };
        System.out.println(largestSubmatrix(matrix));
    }

    public static int largestSubmatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int maxArea = 0;

        for(int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                if(matrix[r][c] == 1 && r > 0){
                    // check for above 1
                    matrix[r][c] += matrix[r-1][c];

                }

            }

            Integer[] arr = Arrays.stream(matrix[r]).boxed().toArray(Integer[]::new);
            Arrays.sort(arr, Collections.reverseOrder());

            for(int c = 0; c < m; c++){
                int area = 0;
                if(arr[c] > 0){
                    area = arr[c] * (c+1);
                }

                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}

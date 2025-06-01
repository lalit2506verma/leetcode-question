package problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SetMatrixZero {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);

//        int m = matrix.length;
//        int n = matrix[0].length;
//        for(int i = 0; i < m; i++){
//            for(int j = 0; j < n; j++){
//                System.out.print(matrix[i][j]);
//            }
//            System.out.println();
//        }
    }

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length; // Row
        int n = matrix[0].length; // column

        int[] markRow = new int[m];
        int[] markCol = new int[n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    markRow[i] = 1;
                    markCol[j] = 1;
                }
            }
        }

        System.out.println(Arrays.toString(markRow));
        System.out.println(Arrays.toString(markCol));
    }
}

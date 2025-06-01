package problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FlipColumnsForEqualRows {
    public static void main(String[] args) {
        int[][] matrix = {{0,0,0},{0,0,1},{1,1,0}};
        System.out.println(maxEqualRowsAfterFlips(matrix));
    }

    public static int maxEqualRowsAfterFlips(int[][] matrix) {
        int m = matrix.length; //row
        int n = matrix[0].length;  // column

        HashMap<String, Integer> map = new HashMap<>();

        for(int[] currRow : matrix){
            StringBuilder pattern = new StringBuilder();

            int intValue = currRow[0];
            // making the pattern
            for(int i = 0; i < n; i++){
                pattern.append(currRow[i] == intValue ? 's':'c');
            }

            String str = pattern.toString();

            if(map.containsKey(str)){
                map.put(str, map.get(str)+1);
            }
            else {
                map.put(str, 1);
            }
        }

        int maxRow = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            maxRow = Math.max(entry.getValue(), maxRow);
        }

        return maxRow;
    }
}

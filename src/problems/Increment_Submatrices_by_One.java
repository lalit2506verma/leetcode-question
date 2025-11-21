package problems;

public class Increment_Submatrices_by_One {
    public static void main(String[] args) {

    }

    public static int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] res = new int[n][n];

        for(int[] q : queries){
            int row1 = q[0], col1 = q[1], row2 = q[2], col2 = q[3];

            for(int i = row1; i <= row2; i++){
                res[i][col1]++;
                if(col2 + 1 < n){
                    res[i][col2+1]--;
                }
            }
        }

        // cumulative sum
        for(int i = 0; i < n; i++){
            for(int j = 1; j < n; j++){
                res[i][j] += res[i][j-1];
            }
        }

        return res;
    }
}

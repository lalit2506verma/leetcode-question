package problems;

public class MaximuSide_Length_of_a_Square_with_Sum_Less_than_or_Equal_to_Threshold {
    public static void main(String[] args) {
        int[][] matrix = {{1,1,3,2,4,3,2}, {1,1,3,2,4,3,2}, {1,1,3,2,4,3,2}};

        System.out.println(maxSideLength(matrix, 4));
    }

    public static int maxSideLength(int[][] mat, int threshold) {
        int maxSide = 0;
        int n =  mat.length;
        int m = mat[0].length;

        // prefix Matrix
        int[][] prefix= new int[n][m+1];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                prefix[i][j] = (i > 0 ? prefix[i-1][j] : 0)
                        + (j > 0 ? prefix[i][j-1] : 0)
                        - (i > 0 && j > 0 ? prefix[i-1][j-1] : 0)
                        + mat[i][j];

            }
        }

        // iterating to all possible square
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int low = 0;
                int high = Math.min(n-i, m-j)-1;

                while( low <= high){
                    int mid = (low+high)/2;

                    if(isValid(prefix, mid, i, j, threshold)){
                        maxSide = Math.max(maxSide, mid + 1);
                        low = mid + 1;
                    }
                    else{
                        high = mid - 1;
                    }
                }
            }
        }

        return maxSide;

    }

    private static boolean isValid(int[][] prefix, int mid, int i, int j,  int threshold) {
        int i2 = i + mid;
        int j2 = j + mid;

        int sqSum = prefix[i2][j2]
                - (i > 0 ? prefix[i-1][j2] : 0)
                - (j > 0 ? prefix[i2][j-1] : 0)
                + (i > 0 && j > 0 ? prefix[i-1][j-1] : 0);

        return sqSum <= threshold;
    }
}

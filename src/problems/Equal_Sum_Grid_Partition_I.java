package problems;

public class Equal_Sum_Grid_Partition_I {
    public static void main(String[] args) {

    }

    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m  = grid[0].length;

        int[][] prefixSum = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i > 0) prefixSum[i][j] += prefixSum[i-1][j];
                if(j > 0) prefixSum[i][j] += prefixSum[i][j-1];
                if(i > 0 && j > 0) prefixSum[i][j] -= prefixSum[i-1][j-1];
                prefixSum[i][j] += grid[i][j];
            }
        }

        int totalSum = prefixSum[n-1][m-1];
        for(int i = 0; i < n; i++){
            int rem = totalSum - prefixSum[i][m-1];
            if(rem == prefixSum[i][m-1]){
                return true;
            }
        }

        for(int j = 0; j < m; j++){
            int rem = totalSum - prefixSum[n-1][j];
            if(rem == prefixSum[n-1][j]){
                return true;
            }
        }

        return false;
    }
}

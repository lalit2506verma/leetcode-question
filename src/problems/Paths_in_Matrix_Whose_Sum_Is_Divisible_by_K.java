package problems;

public class Paths_in_Matrix_Whose_Sum_Is_Divisible_by_K {
    int n;
    int m;
    public static void main(String[] args) {

    }

        public int helper(int[][] grid, int a, int b, int sum, int k){
            if( a == n && b == m){
                return 0;
            }
            // base case
            if(a == n-1 && b == m-1){
                return sum % k == 0 ? 1 : 0;
            }
            int newSum = (sum + grid[a][b]) % k;
            return helper(grid, a + 1, b, newSum, k) + helper(grid, a, b + 1, newSum, k);

        }

        public int numberOfPaths(int[][] grid, int k) {
            n = grid.length; // row
            m = grid[0].length; // cols

            return helper(grid, 0, 0, 0, k);
        }
}

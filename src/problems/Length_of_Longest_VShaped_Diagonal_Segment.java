package problems;

public class Length_of_Longest_VShaped_Diagonal_Segment {
    static int[][] directions = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
    static int n, m;

    public static void main(String[] args) {
        int[][] grid = {{2,2,1,2,2},{2,0,2,2,0},{2,0,1,1,0},{1,0,2,2,2},{2,0,0,2,2}};

        System.out.println(lenOfVDiagonal(grid));
    }

    public static int helper(int[][] grid, int row, int col, int d, boolean hasMadeTurnYet, int val){
        int newRow = row + directions[d][0];
        int newCol = col + directions[d][1];

        // check newRow and newCol are not outside boundaries
        if(newRow < 0 || newRow >= n || newCol < 0 && newCol >= m || grid[newRow][newCol] != val){
            return 0;
        }
        int result = 0;
        int keepMoving = 1+ helper(grid, newRow, newCol, d, hasMadeTurnYet, val == 2 ? 0 : 2);

        result =  Math.max(result, keepMoving);

        if(!hasMadeTurnYet){
            int turn = Math.max(keepMoving, 1 + helper(grid, newRow, newCol, (d+1)%4, true, val == 2 ? 0 : 2));
            result = Math.max(result, turn);
        }

        return result;
    }
    public static int lenOfVDiagonal(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        int maxLen = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                // segment can only start from 1
                if(grid[i][j] == 1){
                    for(int d = 0; d < 4; d++){
                        maxLen = Math.max(maxLen, 1+ helper(grid, i, j, d, false, 2));
                    }
                }

            }
        }

        return maxLen;
    }
}

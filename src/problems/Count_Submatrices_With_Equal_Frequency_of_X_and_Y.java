package problems;

public class Count_Submatrices_With_Equal_Frequency_of_X_and_Y {
    public static void main(String[] args) {

    }

    public static int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] xCount = new int[n][m];
        int[][] yCount = new int[n][m];

        for(int i=0; i< n; i++){
            for(int j = 0; j < m; j++){
                if(i > 0){
                    xCount[i][j] += xCount[i-1][j];
                    yCount[i][j] += yCount[i-1][j];
                }
                if(j > 0){
                    xCount[i][j] += xCount[i][j-1];
                    yCount[i][j] += yCount[i][j-1];
                }
                if(i > 0 && j > 0){
                    xCount[i][j] -= xCount[i-1][j-1];
                    yCount[i][j] -= yCount[i-1][j-1];
                }

                if(grid[i][j] == 'X'){
                    xCount[i][j]++;
                }
                else if(grid[i][j] == 'Y'){
                    yCount[i][j]++;
                }
            }
        }
        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(xCount[i][j] > 0 && xCount[i][j] == yCount[i][j]){
                    count++;
                }
            }
        }

        return count;
    }
}

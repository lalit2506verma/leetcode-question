package problems;

public class Flip_Square_Submatrix_Vertically {
    public static void main(String[] args) {

    }

    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {

        int rs = x;
        int re = x+k-1;

        while(re > rs){
            for(int c = y; c <= y+k-1; c++){
                int temp = grid[rs][c];
                grid[rs][c] = grid[re][c];
                grid[re][c] = temp;
            }
            rs++;
            re--;
        }

        return grid;
    }
}

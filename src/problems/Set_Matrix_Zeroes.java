package problems;

public class Set_Matrix_Zeroes {

    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 3}};

        setZeroes(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
    }

    public static void setZeroes(int[][] matrix) {
        int n = matrix.length; // row
        int m = matrix[0].length; // col

        int firstCellFlag = 1;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 0){
                    //marking col
                    matrix[i][0] = 0;

                    if(j != 0){
                        // marking row
                        matrix[0][j] = 0;
                    }
                    else{
                        firstCellFlag = 0;
                    }
                }
            }
        }

        // traversal from right bottom corner
        for(int i = n-1; i > 0; i--){
            for(int j = m-1; j > 0; j--){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int i = 0; i < n; i++){
            if(firstCellFlag == 0){
                matrix[i][0] = 0;
            }
        }

        for(int j = m-1; j > 0; j--){
            if(matrix[0][0] == 0){
                matrix[0][j] = 0;
            }
        }
    }
}

package problems;

public class Maximum_Area_of_Longest_Diagonal_Rectangle {
    public static void main(String[] args) {
        int[][] dim = {{6,5},{8,6},{2,10},{8,1},{9,2},{3,5},{3,5}};
        System.out.println(areaOfMaxDiagonal(dim));
    }

    public static int areaOfMaxDiagonal(int[][] dim) {
        double maxDia = 0;
        int maxArea = 0;

        for (int[] ints : dim) {
            double dia = Math.sqrt(Math.pow(ints[0], 2) + Math.pow(ints[1], 2));
            if (dia > maxDia) {
                maxDia = dia;
                maxArea = ints[0] * ints[1];
            }
            else if(dia == maxDia){
                maxArea = Math.max(ints[0]*ints[1], maxArea);
            }
        }

        return maxArea;
    }
}

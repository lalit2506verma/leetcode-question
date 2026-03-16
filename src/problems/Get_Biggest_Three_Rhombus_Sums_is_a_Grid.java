package problems;

import java.util.*;

public class Get_Biggest_Three_Rhombus_Sums_is_a_Grid {
    public static void main(String[] args) {
        int[][] grid = {
                {3,4,5,1,3},
                {3,3,4,2,3},
                {20,30,200,40,10},
                {1,5,5,4,1},
                {4,3,2,2,5}
        };

        System.out.println(Arrays.toString(getBiggestThree(grid)));
    }

    public static int[] getBiggestThree(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        SortedSet<Integer> set = new TreeSet<>(Comparator.reverseOrder());

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                // side length
                set.add(grid[i][j]);
                for(int side = 1; i-side >= 0 && i+side < m && j-side >= 0 && j+side < n; side++){
                    int sum = 0;
                    for(int k = 0; k < side; k++){
                        sum += grid[i-side+k][j+k];
                        sum += grid[i+k][j+side-k];
                        sum += grid[i-k][j-side+k];
                        sum += grid[i+side-k][j-k];
                    }
                    set.add(sum);
                }

                while(set.size() > 3){
                    set.remove(set.last());
                }

            }
        }

        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}

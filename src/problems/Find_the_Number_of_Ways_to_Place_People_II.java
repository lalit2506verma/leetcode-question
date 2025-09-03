package problems;

import java.util.Arrays;
import java.util.Comparator;

public class Find_the_Number_of_Ways_to_Place_People_II {
    public static void main(String[] args) {

    }

    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int res = 0;

        // sorting the array based on x (ascending) and y-coordinate as descending
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < n; i++) {
            // point A
            int x1 = points[i][0];
            int y1 = points[i][1];

            int maxY = Integer.MIN_VALUE;
            // point B
            for (int j = i+1; j < n; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];

                // Point B upper chala gaya A se
                if(y2 > y1){
                    continue;
                }

                // check no point lies b/w
                if(y2 > maxY){
                    res++;
                    maxY = y2;
                }
            }

        }

        return res;
    }
}

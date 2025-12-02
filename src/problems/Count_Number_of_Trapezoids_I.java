package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Count_Number_of_Trapezoids_I {
    static int MOD = 1_000_000_007;
    public static void main(String[] args) {
        int[][] points = {{1,0},{2,0},{3,0},{1,1},{2,1},{3,1},{4,1},{5,1},{6,1},{2,2},{3,2}};
        System.out.println(countTrapezoids(points));
    }

    public static int countTrapezoids(int[][] points) {
        HashMap<Integer, Integer> groups = new HashMap<>();

        for(int[] point: points){
            int y = point[1];
            groups.put(y, groups.getOrDefault(y,0)+1);
        }

        List<Long> combinations = new ArrayList<>();
        long sum = 0, ans = 0;
        for(int k: groups.values()){

            if( k > 1){
                combinations.add(((long) k * (k - 1)) / 2L);
            }
        }

        for(long seq : combinations){
            ans = (ans + seq * sum) % MOD;
            sum = (sum + seq) % MOD;
        }

        return (int) ans;
    }
}


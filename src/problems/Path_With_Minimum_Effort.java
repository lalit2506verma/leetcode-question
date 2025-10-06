package problems;

import java.util.*;

public class Path_With_Minimum_Effort {
    static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) {

    }

    public static int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] dis = new int[n][m];

        for(int[] t : dis){
            Arrays.fill(t, Integer.MAX_VALUE);
        }

        // MIN- HEAP of int[] {dis, row, col}
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // Adding the first entry
        pq.offer(new int[] {0, 0, 0});
        dis[0][0] = 0;

        while(!pq.isEmpty()){
            int[] top = pq.poll();

            int d = top[0], r = top[1], c = top[2];

            // check if exsting D is less that dis[r][c]
            if(d > dis[r][c]){
                continue;
            }

            if(r == n-1 && c == m-1){
                return d;
            }

            // Checking Neighbours
            for(int[] dir : directions){
                int nr = r + dir[0];
                int nc = c + dir[1];
                // check if outOf ou of bound
                if(nr >= 0 && nr < n && nc >= 0 && nc < m){
                    // Calculate new Dis
                    int newScope = Math.max(d, Math.abs(heights[r][c] - heights[nr][nc]));

                    if(newScope < dis[nr][nc]){
                        dis[nr][nc] = newScope;
                        pq.offer(new int[] {newScope, nr, nc});
                    }
                }
            }
        }
        return 0;
    }
}



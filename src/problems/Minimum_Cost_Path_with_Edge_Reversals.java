package problems;

import java.util.*;

public class Minimum_Cost_Path_with_Edge_Reversals {
    static List<List<int[]>> graph;
    public static void main(String[] args) {
        int[][] edges = {{0,1,3}, {3,1,1}, {2,3,4}, {0,2,2}};
        System.out.println(minCost(4, edges));
    }

    public static int minCost(int n, int[][] edges) {
        graph = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            int v = edges[i][0], u =  edges[i][1], cost = edges[i][2];
            // original path
            graph.get(v).add(new int[]{u, cost});
            // Reversal Path
            graph.get(u).add(new int[]{v, 2*cost});
        }

        return DijkstraAlgo(n);
    }

        private static int DijkstraAlgo(int n) {
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);

            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
            boolean[] visited = new boolean[n];

            pq.offer(new int[]{0, 0});

            while(!pq.isEmpty()){
                int[] currNode = pq.poll();


                // if already visited then moved to next node
                if(visited[currNode[0]]){
                    continue;
                }
                // marked visited
                visited[currNode[0]] = true;

                for(int[] nbrs : graph.get(currNode[0])){
                    int nextNode =  nbrs[0];
                    int cost = nbrs[1];
                    if(currNode[1] + cost < dist[nextNode]){
                        dist[nextNode] = currNode[1] + cost;
                        pq.offer(new int[]{nextNode, dist[nextNode]});
                    }
                }

            }

            return dist[n-1] == Integer.MAX_VALUE ? -1 : dist[n-1];
        }
}



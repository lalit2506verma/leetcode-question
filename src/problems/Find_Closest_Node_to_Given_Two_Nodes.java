package problems;

import java.util.Arrays;

public class Find_Closest_Node_to_Given_Two_Nodes {
    public static void main(String[] args) {

    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int nodes = edges.length;

        int[] dis_node1 = new int[nodes];
        int[] dis_node2 = new int[nodes];

        Arrays.fill(dis_node1, Integer.MAX_VALUE);
        Arrays.fill(dis_node2, Integer.MAX_VALUE);

        boolean[] visited1 = new boolean[nodes];
        boolean[] visited2 = new boolean[nodes];


        dfs(edges, node1, dis_node1, visited1);
        dfs(edges, node2, dis_node2, visited2);

        int minDisNode = -1;;
        int minDis = Integer.MAX_VALUE;

        for (int i = 0; i < nodes; i++) {
            int max = Math.max(dis_node1[i], dis_node2[i]);

            if(max < minDis){
                minDis = max;
                minDisNode = i;
            }
        }
        return minDisNode;
    }

    private void dfs(int[] edges, int node, int[] dis, boolean[] visited) {
        visited[node] = true;

        int v = edges[node];

        if(v != -1 && !visited[v]){
            // mark it visited
            visited[v] = true;

            // dis calculation
            dis[v] = 1 + dis[node];
            dfs(edges, v, dis, visited);
        }
    }
}

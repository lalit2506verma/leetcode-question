package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Find_All_People_With_Secret {
    public static void main(String[] args) {
        int[][] meetings = {{1,2,5},{2,3,8},{1,5,10}};
        System.out.println(findAllPeople(6, meetings, 1));
    }

    public static List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        // adjacent map  [P1 , [(time, P2), (time, P3), ...]
        HashMap<Integer, List<int[]>> adjacencyList = new HashMap<>();

        for(int[] meeting : meetings){
            int p1 =  meeting[0];
            int p2 =  meeting[1];
            int time = meeting[2];

            adjacencyList.computeIfAbsent(p1, k -> new ArrayList<>()).add(new int[]{time, p2});
            adjacencyList.computeIfAbsent(p2, k -> new ArrayList<>()).add(new int[]{time, p1});
        }

        // Min-heap to store the [time, p2]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        pq.add(new int[]{0,0});
        pq.add(new int[]{0, firstPerson});

        boolean[] visited = new boolean[n];

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int t = curr[0];
            int p = curr[1];

            if(!visited[p]){
                visited[p] = true;

                if(adjacencyList.containsKey(p)){
                    for(int[] meeting : adjacencyList.get(p)){
                        int nextP = meeting[1];
                        int meetTime = meeting[0];

                        if(meetTime >= t && !visited[nextP]){
                            pq.add(new int[]{meetTime, nextP});
                        }
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(visited[i]){
                ans.add(i);
            }
        }

        return ans;
    }
}

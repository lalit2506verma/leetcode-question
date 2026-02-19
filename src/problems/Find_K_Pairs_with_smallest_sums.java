package problems;

import java.util.*;

public class Find_K_Pairs_with_smallest_sums {
    public static void main(String[] args) {

    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]+a[1]-b[0]-b[1]);
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < n; i++){
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }

        while(k-- > 0 && !pq.isEmpty()){
            int[] curr = pq.poll();
            res.add(Arrays.asList(curr[0], curr[1]));

            if(curr[2] == nums2.length-1) continue;
            pq.offer(new int[]{curr[0], nums2[curr[2] + 1], curr[2]});
        }

        return res;
    }
}

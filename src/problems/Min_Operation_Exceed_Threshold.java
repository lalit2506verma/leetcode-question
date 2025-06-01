package problems;

import java.util.PriorityQueue;

public class Min_Operation_Exceed_Threshold {
    public static void main(String[] args) {
        int[] nums = {2,11,10,1,3};
        System.out.println(minOperations(nums, 10));
    }

    public static int minOperations(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }

        int ans = 0;

        while (pq.peek() < k) {

            int first = pq.poll();
            int second = pq.poll();

            int op = Math.min(first, second) * 2 + Math.max(first, second);
            pq.add(op);
            ans++;
        }

        return ans;
    }
}

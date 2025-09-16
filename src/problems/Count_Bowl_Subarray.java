package problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Count_Bowl_Subarray {
    public static void main(String[] args) {
        int[] arr = {5,1,2,3,4};
        System.out.println(bowlSubarrays(arr));
    }

    public static long bowlSubarrays(int[] nums) {
        int n = nums.length;
        long count = 0;

        for(int i = 0; i < n-2; i++){
            int start = nums[i];
            int midMax = nums[i+1];

            if(start < midMax){
                continue;
            }

            for(int j = i+2; j < n; j++){
                int end = nums[j];
                midMax = Math.max(midMax, nums[j-1]);

                // Now check wheather end is also greater or not
                int min = Math.min(start, end);
                if(min > midMax){
                    count++;
                }
            }
        }

        return count;
    }


    public static long bowlSubarrays2(int[] nums) {
        int n = nums.length;

        if(n < 3){
            return 0;
        }

        long count = 0;

        int[] pge = new int[n];
        int[] nge = new int[n];

        Arrays.fill(pge, -1);
        Arrays.fill(nge, -1);

        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                pge[i] = stack.peek();
            }

            stack.push(i);
        }

        stack.clear();

        for(int i = n-1; i >= 0; i--){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                stack.pop();
            }

            if(!stack.isEmpty()){
                nge[i] = stack.peek();
            }

            stack.push(i);
        }

        for(int i = 0; i < n; i++){
            int r = nge[i];
            if(r != -1 && r > i+1){
                count++;
            }

            int l = pge[i];
            if(l != -1 && i > l+1){
                count++;
            }
        }

        return count;
    }
}

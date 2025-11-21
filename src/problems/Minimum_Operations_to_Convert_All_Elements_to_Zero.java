package problems;

import java.util.*;

public class Minimum_Operations_to_Convert_All_Elements_to_Zero {
    public static void main(String[] args) {
        int[] nums = {0,2};
        System.out.println(minOperations(nums));
    }

    public static int minOperations(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        // getting unique value
        for(int num : nums){
            if(num != 0 && !set.contains(num)){
                list.add(num);
                set.add(num);
            }
        }
        int n = nums.length;

        int count = 0;
        for(int i = 0; i < list.size(); i++){
            int num1 = list.get(i);
            boolean isBreak = true;

            for(int j = 0; j < n; j++){
                if(num1 == nums[j]){
                    if(isBreak){
                        count++;
                        isBreak = false;
                    }
                }
                else if(num1 > nums[j]) {
                    isBreak = true;
                }
            }
        }

        return count;
    }

    public int minOperations2(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;

        for(int num : nums){
            while(!st.isEmpty() || st.peek() < num){
                st.pop();
            }

            if( num == 0){
                continue;
            }

            if(st.isEmpty() || st.peek() > num){
                ans++;
                st.push(num);
            }
        }

        return ans;
    }


}

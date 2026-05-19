package problems;

import java.util.HashMap;

public class Minimum_Absolute_Distance_Between_Mirror_Pairs {
    public static void main(String[] args) {
        int[] nums = {12,21,45,33,54};
        System.out.println(minMirrorPairDistance(nums));
    }

    public static int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        int minDis = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            int reverse = reverse(nums[i]);
            if(map.containsKey(nums[i])){
                minDis = Math.min(minDis, i - map.get(nums[i]));
            }
            map.put(reverse, i);
        }

        return minDis == Integer.MAX_VALUE ? -1 : minDis;
    }

    public static int reverse(int n){
        int reverse = 0;
        while(n > 0){
            int digit = n % 10;
            reverse = reverse * 10 + digit;
            n /= 10;
        }
        return reverse;
    }
}

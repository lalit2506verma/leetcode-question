package problems;

import java.util.HashMap;

public class Largest_SubArray {
    public static void main(String[] args) {
        int[] arr = {-31, -48, -90, 54, 20, 95, 6, -86, 22};
        System.out.println(subArray(arr));
    }

    public static int subArray(int[] arr){
        int maxLen = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            if(prefixSum == 0){
                maxLen = i+ 1;
            }

            if(map.containsKey(prefixSum)){
                maxLen = Math.max(maxLen, i - map.get(prefixSum));
            }
            else{
                map.put(prefixSum, i);
            }
        }

        return maxLen;
    }
}

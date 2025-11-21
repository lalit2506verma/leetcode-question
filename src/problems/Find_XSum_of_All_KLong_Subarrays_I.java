package problems;

import java.util.*;

public class Find_XSum_of_All_KLong_Subarrays_I {
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,4,2,3};
        System.out.println(Arrays.toString(findXSum(nums, 6, 2)));
    }

    public static int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] res = new int[Math.max(0, n-k+1)];

        HashMap<Integer, Integer> map = new HashMap<>();

        // first window
        for(int i = 0; i < k; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1 );
        }

        res[0] = computeXSum(map, x);

        for(int i = k; i < n; i++){
            int add = nums[i];
            int rem = nums[i - k];

            // add the number
            map.put(add, map.getOrDefault(add, 0) + 1);

            // remove freq
            int newFreq = map.get(rem) - 1;
            if(newFreq == 0) map.remove(rem);
            else map.put(rem, newFreq);

            res[i-k+1] = computeXSum(map, x);
        }

        return res;
    }

    private static int computeXSum(HashMap<Integer, Integer> map, int x) {
        List<int[]> list = new ArrayList<>();

        for(Map.Entry<Integer, Integer> pair: map.entrySet()){
            list.add(new int[]{pair.getKey(), pair.getValue()});
        }

        // Sort the array
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o2[1] == o1[1]){
                    return o2[0] - o1[0];
                }
                return o2[1] - o1[1];
            }
        });

        int sum = 0;
        int take = Math.min(x, list.size());
        for(int i = 0; i < take; i++){
            sum += list.get(i)[1] * list.get(i)[0];
        }

        return sum;
    }
}

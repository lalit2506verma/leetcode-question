package problems;

import java.util.*;

public class Minimum_Pair_Removal_to_Sort_Array_I {
    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 1};
        System.out.println(minimumPairRemoval(arr));
    }

    public static int minimumPairRemoval(int[] nums) {
        int count = 0;
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            list.add(num);
        }

        while(list.size()>1){
            boolean isSorted = true;
            int minSum = Integer.MAX_VALUE;
            int minIndex = -1;

            for(int i=1; i < list.size(); i++){
                int sum = list.get(i) + list.get(i-1);
                if(sum < minSum){
                    minSum = sum;
                    minIndex = i;
                }

                if(list.get(i-1) > list.get(i)){
                    isSorted = false;
                }
            }

            if(isSorted){
                break;
            }

            list.set(minIndex, minSum);
            list.remove(minIndex - 1);
            count++;
        }

        return count;

    }
}

package problems;

import java.util.Arrays;
import java.util.HashSet;

public class Tuple_with_Same_Product {
    public static void main(String[] args) {
        int[] nums = {2,3,4,6};

        System.out.println(tupleSameProduct(nums));
    }

    public static int tupleSameProduct(int[] nums){
        int n = nums.length;
        int tupleCount = 0;

        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            for (int j = n-1; j > i; j--) {
                int product = nums[i] * nums[j];
                HashSet<Integer> set = new HashSet<>();

                for(int k = i+1; k < j; k++){
                    if(product % nums[k] == 0){
                        int dValue = product/nums[k];
                        if(set.contains(dValue)){
                            tupleCount++;
                        }
                        set.add(nums[k]);
                    }
                }
            }
        }

        return tupleCount * 8;
    }
}

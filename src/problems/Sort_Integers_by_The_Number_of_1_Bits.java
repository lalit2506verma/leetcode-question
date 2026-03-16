package problems;

import java.util.Arrays;

public class Sort_Integers_by_The_Number_of_1_Bits {
    public static void main(String[] args) {

    }

    public int[] sortByBits(int[] arr) {
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(nums, (a, b)-> {
            int countBitA = Integer.bitCount(a);
            int countBitB = Integer.bitCount(b);

            if(countBitB == countBitA){
                return a - b;
            }
            return countBitA - countBitB;
        });

        for(int i = 0; i < nums.length; i++){
            arr[i] = nums[i];
        }

        return arr;
    }
}

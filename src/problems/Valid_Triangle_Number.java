package problems;

import java.util.Arrays;

public class Valid_Triangle_Number {
    public static void main(String[] args) {
        int[] nums = {1, 1, 3, 4};
        System.out.println(triangleNumber(nums));
    }

    public static int triangleNumber(int[] nums) {
        int n = nums.length;
        // SORTING THE ARRAY
        Arrays.sort(nums); // n * log n
        int count = 0;


        // FINDIG THE FIRST NUMBER
        for(int i = 0; i < n; i++){

            // SECOND NUMBER
            for(int j = i+1; j < n; j++){
                int twoSideSum = nums[i] + nums[j];

                int endIndex = upperBound(nums, j+1, n-1, twoSideSum);

                // NUMBER OF POTENTIAL ANSWER
                if(endIndex > j){
                    count += endIndex - j;
                }
            }
        }

        return count;
    }

    public static int upperBound(int[] nums, int start, int end, int target){
        int result = -1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(nums[mid] < target){
                result = mid;
                start = mid + 1;
            }
            else{
                end = mid -1;
            }
        }

        return result;
    }
}

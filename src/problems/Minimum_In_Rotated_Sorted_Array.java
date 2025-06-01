package problems;

import java.util.Arrays;
import java.util.List;

public class Minimum_In_Rotated_Sorted_Array {
    public static void main(String[] args) {
        Integer[] arr = {5,1,2,3,4};
        List<Integer> nums = Arrays.asList(arr);

        System.out.println(findMin(nums));
    }

    public static int findMin(List<Integer> arr) {
        int low = 0;
        int high = arr.size()-1;
        int ans = Integer.MAX_VALUE;
        int idx = -1;

        while(low <= high){
            int mid = low + (high - low)/ 2;

            // at any point if the whole search space is sorted
            if(arr.get(low) <= arr.get(high)){
                if(arr.get(low) < ans){
                    ans = arr.get(low);
                    idx = low;
                }
                break;
            }

            // if left half is sorted
            if(arr.get(low) <= arr.get(mid)){
                if(arr.get(low) < ans){
                    ans = arr.get(low);
                    idx = low;
                }

                low = mid  + 1;
            }

            else{
                if(arr.get(mid) < ans){
                    ans = arr.get(mid);
                    idx = mid;
                }
                high = mid - 1;
            }

        }

        return idx;

    }
}

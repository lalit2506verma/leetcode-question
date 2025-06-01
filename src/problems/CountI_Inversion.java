package problems;

import java.util.ArrayList;
import java.util.Arrays;

public class CountI_Inversion {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        int res = mergeSort(arr, 0, arr.length-1);
        System.out.println(res);
        System.out.println(Arrays.toString(arr));
    }

    public static int merge(int[] nums, int low, int mid, int high){
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        int left = low;
        int right = mid+1;

        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                list.add(nums[left]);
                left++;
            }
            // nums[left] > nums[right]
            else{
                count += mid-left+1;
                list.add(nums[right]);
                right++;
            }
        }

        // if any of the array's part left out
        while(left <= mid){
            list.add(nums[left]);
            left++;
        }

        while(right <= high){
            list.add(nums[right]);
            right++;
        }

        // transferring all the element from temp to original array
        for (int i = low; i <= high; i++) {
            nums[i] = list.get(i-low);
        }

        return count;
    }

    public static int mergeSort(int[] nums, int low, int high){
        int count = 0;
        if(low < high){
            int mid = low + (high- low) / 2;
            // Divide
            count += mergeSort(nums, low, mid);
            count += mergeSort(nums, mid+1, high);

            //Conquer
            count += merge(nums, low, mid, high);
        }
        return count;
    }
}

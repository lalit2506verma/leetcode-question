package problems;

import java.util.ArrayList;

public class Reverse_Pair {
    public static void main(String[] args) {
        int[] arr = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        System.out.println(reversePairs(arr));
    }

    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }

    public static int mergeSort(int[] nums, int low, int high){
        int count = 0;
        if(low < high){
            int mid = (low + high)/2;
            count += mergeSort(nums, low, mid);
            count += mergeSort(nums, mid+1, high);
            // Before merging we will count the pairs by for loop
            count += countPairs(nums, low, mid, high);
            merge(nums, low, mid,high);
        }
        return count;
    }

    private static int countPairs(int[] nums, int low, int mid, int high) {
        int right = mid +1;
        int count = 0;
        for(int i = low; i <= mid; i++){
            while(right <= high && (long)nums[i] > (long)2*nums[right]){
                right++;
            }
            count += (right - (mid+1));
        }

        return count;
    }

    public static void merge(int[] nums, int low, int mid, int high){
        ArrayList<Integer> list = new ArrayList<>();

        int left = low;
        int right = mid+1;
        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                list.add(nums[left]);
                left++;
            }
            else{
                list.add(nums[right]);
                right++;
            }
        }

        while(left <= mid){
            list.add(nums[left]);
            left++;
        }

        while(right <= high){
            list.add(nums[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            nums[i] = list.get(i-low);
        }
    }
}

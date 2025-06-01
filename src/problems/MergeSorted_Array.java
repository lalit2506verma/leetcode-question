package problems;

import java.util.Arrays;

public class MergeSorted_Array {
    public static void main(String[] args){
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n = 1;

        merge(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m-1;
        int j = n-1;
        int k = m+n-1;

        while(j >= 0){
            if(i >= 0 && nums1[i] > nums2[j]){
                // swap with zero
                swap(nums1, i, k);
                k--;
                i--;
            }
            else{
                // destroying zero
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }
    }

    private static void swap(int[] nums1, int i, int k) {
        int temp = nums1[i];
        nums1[i] = nums1[k];
        nums1[k] = temp;
    }
}

package problems;

import java.util.Arrays;

public class Max_Dot_Product_of_Two_Subsequences {
    public static void main(String[] args) {
        int[] nums1 = {2,1,-2,5};
        int[] nums2 = {3,0,-6};

        System.out.println(maxDotProduct(nums1, nums2));
    }

    public static int helper(int[] nums1, int[] nums2, int i, int j, Integer[][] dp) {

        if(i == nums1.length || j == nums2.length){
            return Integer.MIN_VALUE;
        }

        if(dp[i][j] != null){
            return dp[i][j];
        }

        // take j and take i
        int takeBoth = nums1[i] * nums2[j]
                + (i+1 < nums1.length && j+1 < nums2.length ? helper(nums1, nums2, i + 1, j + 1, dp) : 0);
        int n1 = helper(nums1, nums2, i+1, j, dp);
        int n2 = helper(nums1, nums2, i, j+1, dp);

        return dp[i][j] = Math.max(nums1[i] * nums2[j], Math.max(takeBoth, Math.max(n1, n2)));
    }

    public static int maxDotProduct(int[] nums1, int[] nums2) {
        Integer[][] dp = new Integer[nums1.length+1][nums2.length+1];
        return helper(nums1, nums2, 0, 0, dp);
    }
}

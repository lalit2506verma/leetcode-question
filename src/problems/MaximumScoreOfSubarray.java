package problems;

public class MaximumScoreOfSubarray {
    public static void main(String[] args) {
        int[] arr = {4, 3, 1, 5, 6};
        System.out.println(pairWithMaxSum(arr));
    }

    public static int pairWithMaxSum(int[] arr) {
        // Your code goes here

        int maxSum = 0;

        int i = 0;
        int j = 0;
        while( j < arr.length){
            int sum = arr[i] + arr[j];
            maxSum = Math.max(sum, maxSum);
            i++;
            j++;
        }

        return maxSum;
    }
}

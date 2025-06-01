package problems;

public class LongestSubarrayWithSum {
    public static void main(String[] args) {
        int[] arr = {783, 0, 615, 868, 783, 0, 615, 868};
        System.out.println(lenOfLongestSubarr(arr, 2266));
    }

    public static int lenOfLongestSubarr(int[] arr, int k) {
        int maxCount = 0;
        int i = 0;
        int j = 0;
        int sum = arr[0];

        while(j < arr.length){
            if(sum < k){
                j++;
                sum += arr[j];
            }
            else if(sum > k){
                sum -= arr[i];
                i++;
            }
            else {
                maxCount = Math.max(maxCount, j - i + 1);
                j++;
                if(j < arr.length) sum += arr[j];
            }
        }

        return maxCount;
    }
}

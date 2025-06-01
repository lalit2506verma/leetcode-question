package problems;

public class Maximum_count_positive_negative {
    public static void main(String[] args) {
        int[] nums = {-1563,-236,-114,-55,427,447,687,752,1021,1636};

        System.out.println(maximumCount(nums));
    }

    public static int maximumCount(int[] nums) {
        int n = nums.length;
        int posiCount = positiveCount(nums);

        int negaCount = negativeCount(nums);

        return Math.max(n - posiCount, negaCount);
    }

    private static int negativeCount(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] < 1){
                low = mid +1;
            }
            else{
                high = mid -1;
            }
        }
        return low;
    }

    private static int positiveCount(int[] nums) {
        int low = 0;
        int high = nums.length -1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(nums[mid] > -1){
                high = mid - 1;
            }
            else {
                low = mid+1;
            }
        }

        return low;
    }
}

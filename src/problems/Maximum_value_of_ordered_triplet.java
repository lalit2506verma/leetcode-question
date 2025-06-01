package problems;

public class Maximum_value_of_ordered_triplet {
    public static void main(String[] args) {
        int[] nums = {12,6,1,2,7};
        System.out.println(maximumTripletValue(nums));
    }

    public static long maximumTripletValue(int[] nums) {
        long max = 0;
        for(int i = 0; i < nums.length; i++){
            int a = nums[i];

            for(int j = i+1; j < nums.length; j++){
                int b = nums[j];

                if(a > b){
                    for(int k = j + 1; k < nums.length; k++){
                        int c = nums[k];
                        max = Math.max(max, ((long) (a - b) * k));
                    }
                }
            }
        }
        return max;
    }
}

package problems;

public class Make_Array_Elements_Equal_to_Zero {
    public static void main(String[] args) {
        int[] nums = {16,13,10,0,0,0,10,6,7,8,7};
        System.out.println(countValidSelections(nums));
    }

    public static int countValidSelections(int[] nums) {
        int total = 0, leftSum = 0, count = 0;
        for(int num : nums){
            total += num;
        }

        for(int num: nums){
            int rightSum = total - leftSum - num;
            if(num == 0){
                if(rightSum == leftSum){
                    count += 2;
                }
                else if(Math.abs(leftSum - rightSum) == 1){
                    count++;
                }
            }
            leftSum += num;
        }

        return count;
    }
}

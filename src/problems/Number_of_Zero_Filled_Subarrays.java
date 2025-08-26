package problems;

public class Number_of_Zero_Filled_Subarrays {
    public static void main(String[] args) {
        int[] arr = {2,10,2019};
        System.out.println(zeroFilledSubarray(arr));
    }

    public static long zeroFilledSubarray(int[] nums) {
        long res = 0;
        int consZero = 0;
        for(int num: nums){
            if(num == 0){
                res += (consZero + 1);
                consZero++;
            }
            else{
                consZero = 0;
            }
        }

        return res;
    }
}

package problems;

public class SecondLargetNumber {
    public static void main(String[] args) {
        int[] nums = {12, 35, 1, 10, 34, 1};
        System.out.println(getSecondLargest(nums));
    }

    public static int getSecondLargest(int[] arr) {
        int max = arr[0];
        int secondMax = -1;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max ){
                secondMax = max;
                max = arr[i];
            }
            if(arr[i] > secondMax && arr[i] < max){
                secondMax = arr[i];
            }
        }

        return secondMax;

    }
}

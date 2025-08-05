package problems;

import java.util.ArrayList;

public class Count_Hills_and_Valleys_in_an_Array {
    public static void main(String[] args) {
        int[] arr = {2,4,1,1,6,5};
        System.out.println(countHillValley(arr));
    }

    public static int countHillValley(int[] nums) {
        // remove the adjacent duplicate from the nums
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]){
                list.add(nums[i]);
            }
        }
        int count = 0;

        for(int i = 1; i < list.size()-1; i++){
            if((list.get(i-1) < list.get(i) && list.get(i+1) < list.get(i)) || (list.get(i-1) > list.get(i) && list.get(i+1) > list.get(i))){
                count++;
            }
        }

        return count;
    }
}

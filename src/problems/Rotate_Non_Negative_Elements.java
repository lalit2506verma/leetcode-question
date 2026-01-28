package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Rotate_Non_Negative_Elements {
    public static void main(String[] args) {
        int[] arr = {1,-2,3,-4};
        System.out.println(Arrays.toString(rotateElements(arr, 3)));
    }

    public static int[] rotateElements(int[] nums, int k) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();

        for(int num : nums){
            if(num >= 0){
                list.add(num);
            }
        }

        int l = list.size();
        int rightRotate = l - k;

        Collections.rotate(list, rightRotate);

        int idx = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] >= 0){
                nums[i] = list.get(idx++);
            }
        }

        return nums;
    }
}

package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Missing_and_Repeating {
    public static void main(String[] args) {
        int[] arr = {6,5,8,7,1,4,1,3,2};
        ArrayList<Integer> list = findTwoElement(arr);

        System.out.println(list.toString());
    }

    public static ArrayList<Integer> findTwoElement(int[] arr){
        int i = 0;
        int[] res = new int[2];
        while(i < arr.length){
            if(arr[i] == i+1){
                i++;
            }
            else{
                if(arr[i] != arr[arr[i]-1]){
                    swap(arr, i, arr[i] -1);
                }
                else{
                    res[0] = arr[i];
                    res[1] = i+1;
                    i++;
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int n: res){
            list.add(n);
        }
        return list;
    }

    private static void swap(int[] nums1, int i, int k) {
        int temp = nums1[i];
        nums1[i] = nums1[k];
        nums1[k] = temp;
    }
}

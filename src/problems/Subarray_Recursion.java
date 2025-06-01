package problems;

import java.util.Arrays;
import java.util.Scanner;

public class Subarray_Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        System.out.println(firstoccurance(arr, target, 0));
        System.out.println(lastoccurance(arr, target, arr.length-1));
    }

    public static int firstoccurance(int[] arr, int target, int idx){
        if(idx == arr.length){
            return -1;
        }

        if(arr[idx] == target){
            return idx;
        }

        return firstoccurance(arr, target, idx+1);
    }

    public static int lastoccurance(int[] arr, int target, int idx){
        if(idx < 0){
            return -1;
        }

        if(arr[idx] == target){
            return idx;
        }

        return lastoccurance(arr, target, idx-1);
    }
}

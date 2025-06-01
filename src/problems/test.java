package problems;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] arr = {2,3,7,6,8,9};

        for(int i = 0; i < arr.length; i++){
            if(i % 2 == 0){
                //Even
                if(arr[i] % 2 != 0){
                    replace(arr, i, i+1);
                }
            }
            else{
                //Odd
                if(arr[i] % 2 == 0){
                    replace(arr, i, i+1);
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    private static void replace(int[] arr, int i, int i1) {
        int temp = arr[i];
        arr[i] = arr[i+1];
        arr[i+1] = temp;
    }
}

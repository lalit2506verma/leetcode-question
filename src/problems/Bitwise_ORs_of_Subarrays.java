package problems;

import java.util.HashSet;

public class Bitwise_ORs_of_Subarrays {
    static HashSet<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        int[] arr = {1, 2, 4};
        System.out.println(subarrayBitwiseORs(arr));
    }

    public static int subarrayBitwiseORs(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < (1 << n); i++){
            findOR(arr, i);
        }

        return set.size();
    }

    private static void findOR(int[] arr, int i) {
        int pos = 0;
        int OR = 0;
        while(i > 0){
            if((i & 1) != 0){
                OR = OR | arr[pos];
            }
            pos++;
            i >>= 1;
        }

        set.add(OR);
    }
}

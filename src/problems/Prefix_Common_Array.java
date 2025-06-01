package problems;

import java.util.HashMap;

public class Prefix_Common_Array {
    public static void main(String[] args) {

    }

    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] res = new int[A.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i < A.length; i++){
            map.put(A[i], map.getOrDefault(A[i], 0) +1);
            map.put(A[i], map.getOrDefault(B[i], 0) +1);

            if(map.get(A[i]) == 2){
                count++;
            }
            if(map.get(B[i]) == 2){
                count++;
            }

            res[i] = count;
        }

        return res;
    }
}

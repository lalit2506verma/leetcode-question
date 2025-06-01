package problems;

import java.util.Arrays;

public class DefuseTheBomb {
    public static void main(String[] args) {
        int[] code = {5,7,1,4};
        System.out.println(Arrays.toString(decrypt(code, 3)));
    }

    public static int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            for(int j = i+1; j <= i + k; j++){
                if(j >= n){
                    j = j % n;
                }
                res[i] += code[j];
            }
        }

        return res;
    }
}

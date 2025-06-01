package problems;

import java.util.ArrayList;
import java.util.Arrays;

public class Finding_3Digit_Even_Numbers {
    public static void main(String[] args) {
        int[] digits = {2,2,8,8,2};
        System.out.println(Arrays.toString(findEvenNumbers(digits)));
    }

    public static int[] findEvenNumbers(int[] digits) {
        int[] freq = new int[10];

        for(int d: digits){
            freq[d]++;
        }

        ArrayList<Integer> res = new ArrayList<>();
        // select only even number
        for(int i = 100; i < 999; i += 2){
            int a = (i % 10);  // zeroth place
            int b = (i / 10) % 10;
            int c = (i / 100) % 10;

            int[] tempFreq = new int[10];
            tempFreq[a]++;
            tempFreq[b]++;
            tempFreq[c]++;

            boolean flag = true;
            for(int j = 0; j < 10; j++){
                if(tempFreq[j] > freq[j]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                res.add(i);
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}

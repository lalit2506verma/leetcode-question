package problems;

import java.util.HashSet;
import java.util.Set;

public class Prime_Number_of_Set_Bits_in_Binary_Representation {
    public static void main(String[] args) {
        System.out.println(countPrimeSetBits(6, 10));
    }

    public static int countPrimeSetBits(int left, int right) {
        int count = 0;
        Set<Integer> set = Set.of(2, 3, 5, 7, 11, 13, 17,19);


        for(int i = left; i <= right; i++){
            if(set.contains(countSetBit(i))){
                count++;
            }
        }

        return count;
    }

    public static int countSetBit(int num){
        int count = 0;
        while(num > 0){
            num &= (num-1);
            count++;
        }

        return count;
    }
}

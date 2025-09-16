package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Replace_Non_Coprime_Numbers_in_Array {
    public static void main(String[] args) {
        int[] arr = {287,41,49,287,899,23,23,20677,5,825};
        System.out.println(replaceNonCoprimes(arr));
    }

    public static List<Integer> replaceNonCoprimes(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();

        for (int num : nums){

            while(!stack.isEmpty()){
                int prev = stack.peek();
                int curr = num;

                int gcd = gcd(prev, curr);
                if (gcd == 1){
                    break;
                }

                stack.pop();
                int lcm = prev / gcd * curr;
                num = lcm;
            }

            stack.push(num);
        }

        return stack.stream().toList();
    }

    public static int gcd(int a, int b){
        if(b == 0){
            return a;
        }

        return gcd(b, a % b);
    }
}

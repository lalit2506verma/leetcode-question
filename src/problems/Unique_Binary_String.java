package problems;

import java.util.Arrays;
import java.util.HashSet;

public class Unique_Binary_String {
    static String ans = "";
    public static void main(String[] args) {
        String[] nums ={"01","10"};
        System.out.println(findDifferentBinaryString1(nums));
    }

    public static String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        HashSet<String> set = new HashSet<>(Arrays.asList(nums));
        StringBuilder str = new StringBuilder();
        generateString(n, str, set);

        return ans;
    }

    public static void generateString(int n, StringBuilder str, HashSet<String> set){
        if(str.length() == n && !set.contains(str.toString())){
            ans = str.toString();
            return;
        }
        if(str.length()> n){
            return;
        }
        str.append('0');
        generateString(n, str, set);
        str.deleteCharAt(str.length()-1);

        str.append('1');
        generateString(n, str, set);
        str.deleteCharAt(str.length()-1);
    }

    // Better Approach
    public static String findDifferentBinaryString1(String[] nums) {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < nums.length; i++) {
            if(nums[i].charAt(i) == '1'){
                str.append('0');
            }
            else{
                str.append('1');
            }
        }

        return str.toString();
    }
}

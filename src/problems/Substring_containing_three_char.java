package problems;

import java.util.HashMap;

public class Substring_containing_three_char {
    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(numberOfSubstrings(s));
    }

    public static int numberOfSubstrings(String s) {
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int i = 0, j = 0;
        while(j < n){
            char c = s.charAt(j);

            map.put(c, map.getOrDefault(c, 0)+1);

            while(map.getOrDefault('a', 0) > 0 && map.getOrDefault('b', 0) > 0 && map.getOrDefault('c', 0) > 0){
                res += (n - j);
                char ch = s.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0)-1);
                i++;
            }
            j++;
        }
        return res;
    }

}

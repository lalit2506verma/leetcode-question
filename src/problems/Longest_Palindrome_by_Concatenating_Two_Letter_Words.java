package problems;

import java.util.HashMap;

public class Longest_Palindrome_by_Concatenating_Two_Letter_Words {
    public static void main(String[] args) {
        String[] words = {"cc","ll","xx"};
        System.out.println(longestPalindrome(words));
    }

    public static int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int len = 0;

        for(String word : words){
            StringBuilder sb = new StringBuilder(word);
            String reverseStr = sb.reverse().toString();

            if(map.containsKey(reverseStr)){
                len += 4;
                map.put(reverseStr, map.get(reverseStr) - 1);

                if(map.get(reverseStr) == 0){
                    map.remove(reverseStr);
                }
            }
            else{
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        //check for symmetric characters string
        for(String key : map.keySet()){
            int freq = map.get(key);
            if(key.charAt(0) == key.charAt(1) && freq > 0){
                len += 2;
                break;
            }
        }

        return len;
    }
}

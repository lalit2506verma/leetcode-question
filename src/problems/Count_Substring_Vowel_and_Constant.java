package problems;

import java.util.HashMap;

public class Count_Substring_Vowel_and_Constant {
    public static void main(String[] args) {
        String word = "aoaiuefi";
        System.out.println(countOfSubstrings(word, 1));
    }

    public static long countOfSubstrings(String word, int k) {
        int n = word.length();
        int consoCount = 0;
        int res = 0;

        int lastConsIdx = n;
        int[] rightCons = new int[n];
        for (int i = n-1; i >= 0; i--) {
            rightCons[i] = lastConsIdx;
            if(!isVowel(word.charAt(i))){
                lastConsIdx = i;
            }
        }

        HashMap<Character, Integer> map = new HashMap<>();

        int i = 0, j = 0;

        while(j < word.length()){
            char c = word.charAt(j);
            // grow
            if(isVowel(c)){
                map.put(c, map.getOrDefault(c, 0)+1);
            }
            else{
                consoCount++;
            }

            // shrink
            while(consoCount > k){
                char leftChar = word.charAt(i);

                if(isVowel(leftChar)){
                    map.put(leftChar, map.get(leftChar)-1);
                    // remove the vowel if value is 0
                    if(map.get(leftChar) == 0){
                        map.remove(leftChar);
                    }
                }
                else{
                    consoCount--;
                }
                i++;
            }

            // calculate result
            if(consoCount == k && map.size() == 5){
                res = res + (rightCons[j] - j);
            }

            j++;
        }

        return res;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}

package problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountVowelStringsRange {
    public static void main(String[] args) {
        String[] words = {"aba","bcb","ece","aa","e"};
        int[][] queries = {{0,2},{1,4},{1,1}};

        System.out.println(Arrays.toString(vowelStrings(words, queries)));
    }

    public static int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefixSum = new int[words.length];

        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        for(int i = 0; i < words.length; i++){
            int n = words[i].length();

            if(vowels.contains(words[i].charAt(0)) && vowels.contains(words[i].charAt(n-1))){
                prefixSum[i] = prefixSum[Math.max(0, i-1)] + 1;
            }
            else{
                prefixSum[i] = prefixSum[Math.max(0, i-1)];
            }

        }

        int[] ans = new int[queries.length];

        for(int i = 0; i < queries.length; i++){
            int[] query = queries[i];

            if(query[0] != 0){
                ans[i] = prefixSum[query[1]] - prefixSum[query[0] - 1];
            }
            else{
                ans[i] = prefixSum[query[1]];
            }

        }

        return ans;
    }
}

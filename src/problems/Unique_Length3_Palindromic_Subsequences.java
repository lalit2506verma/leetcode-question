package problems;

import java.util.Arrays;

public class Unique_Length3_Palindromic_Subsequences {
    public static void main(String[] args) {
        String s = "bbcbaba";
        System.out.println(countPalindromicSubsequence(s));
    }

    public static int countPalindromicSubsequence(String s) {
        int n = s.length();
        int ans = 0;
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);

        for(int i = 0; i < n; i++){
            int idx = s.charAt(i) - 'a';
            if(first[idx] == -1){
                first[idx] = i;
            }
            last[idx] = i;
        }

        for(int i = 0; i < 26; i++){
            int start = first[i];
            int end = last[i];

            if(end - start < 2) continue;

            boolean[] letter = new boolean[26];

            for(int j = start + 1; j < end; j++){
                int idx = s.charAt(j) - 'a';
                if(!letter[idx]){
                    letter[idx] = true;
                    ans++;
                }
            }
        }

        return ans;

    }
}

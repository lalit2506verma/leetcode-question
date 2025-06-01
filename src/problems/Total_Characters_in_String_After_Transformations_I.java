package problems;

import java.util.Arrays;

public class Total_Characters_in_String_After_Transformations_I {
    static int M = 100_00_00_007;
    public static void main(String[] args) {
        String s = "jqktcurgdvlibczdsvnsg";
        System.out.println(lengthAfterTransformations(s, 7517));
    }

    public static int lengthAfterTransformations(String s, int t) {
        int[] freq = new int[26];

        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }

        for (int i = 1; i <= t; i++) {
            int[] tempFreq = new int[26];

            for (int j = 0; j < freq.length; j++) {
                char ch = (char)('a' + j);
                int fr = freq[j];
                if(ch == 'z'){
                    tempFreq[0] = (tempFreq[0] + fr) % M; // for 'a'
                    tempFreq[1] = (tempFreq[1] + fr) % M; // for 'b'
                }
                else{
                    // for non 'z' character
                    tempFreq[j + 1] = (tempFreq[j + 1] + fr) % M;
                }
            }
            freq = tempFreq;
        }

        int count = 0;
        for(int n : freq){
            count = (count + n) % M;
        }

        return count;
    }
}

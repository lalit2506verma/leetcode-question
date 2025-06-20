package problems;

public class Max_Diff_Between_Even_and_Odd {
    public static void main(String[] args) {
        System.out.println(maxDifference("aaaaabbc"));
    }

    public static int maxDifference(String s) {
        int[] freq = new int[26];

        // freq of earch char
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }

        int maxOddFreq = 0;
        int minEvenFreq = Integer.MAX_VALUE;

        for(int i = 0; i < 26; i++){
            // even freq
            if(freq[i] != 0 && freq[i] % 2 == 0){
                minEvenFreq = Math.min(minEvenFreq, freq[i]);
            }
            else{
                maxOddFreq = Math.max(maxOddFreq, freq[i]);
            }
        }

        return maxOddFreq - minEvenFreq;
    }
}

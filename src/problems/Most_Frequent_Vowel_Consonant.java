package problems;

public class Most_Frequent_Vowel_Consonant {
    public static void main(String[] args) {
        String s = "successes";
        System.out.println(maxFreqSum(s));
    }

    public static int maxFreqSum(String s){
        int[] freq = new int[26];
        int vFreq = 0;
        int cFreq = 0;

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if(isVowel(i)){
                vFreq = Math.max(freq[i], vFreq);
            }
            else{
                cFreq = Math.max(freq[i], cFreq);
            }
        }

        return vFreq + cFreq;
    }

    private static boolean isVowel(int i) {
        return i == 0 || i == 4 || i == 8 || i == 14 || i == 20;
    }
}

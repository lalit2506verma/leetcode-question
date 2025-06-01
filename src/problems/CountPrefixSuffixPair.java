package problems;

public class CountPrefixSuffixPair {
    public static void main(String[] args) {
        String[] words = {"a","aba","ababa","aa"};

        System.out.println(countPrefixSuffixPairs(words));
    }

    public static boolean isPrefixSuffixPairs(String str1, String str2){
        // check str1 is prefix and suffix of str2
        // KMP - algo
        if(str1.length() > str2.length()){
            return false;
        }

        return str2.startsWith(str1) && str2.endsWith(str1);
    }

    public static int countPrefixSuffixPairs(String[] words) {
        int count = 0;

        for(int i = 0; i < words.length-1; i++){
            for(int j = i+1; j < words.length; j++){
                if(isPrefixSuffixPairs(words[i], words[j])){
                    count++;
                }
            }
        }

        return count;
    }
}

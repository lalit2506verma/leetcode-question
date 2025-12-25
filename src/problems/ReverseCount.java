package problems;

import java.util.HashSet;

public class ReverseCount {
    public static void main(String[] args) {

    }

    public String reverseWords(String s) {

        String[] str = s.split(" ");
        int n = str.length;

        int firstVowelCount = vowelCount(str[0]);
        StringBuilder sb = new StringBuilder(str[0]);

        for(int i = 1; i < n; i++){
            if(vowelCount(str[i]) == firstVowelCount){
                sb.append(reverse(str[i]));
            }
            else{
                sb.append(str[i]);
            }

            if(i != n-1){
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    private String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private int vowelCount(String s){
        int count = 0;

        for(char c : s.toCharArray()){
            if(isVowel(c)){
                count++;
            }
        }
        return count;
    }

    private boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}

package problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Vowel_Spellchecker {
    public static void main(String[] args) {
        String[] wordList = {"KiTe","kite","hare","Hare"};
        String[] queries = {"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"};

        System.out.println(Arrays.toString(spellchecker2(wordList, queries)));

    }

    // Brute Force
    public static String[] spellchecker(String[] wordlist, String[] queries) {
        int n = queries.length;
        String[] ans = new String[n];
        int i = 0;

        for(String query : queries){
            boolean flag = false;

            // first exact match
            for(String word : wordlist){
                if(word.length() != query.length()){
                    continue;
                }

                if(query.equals(word)){
                    ans[i++] = word;
                    flag = true;
                    break;
                }
            }

            if(!flag){
                for(String word : wordlist){
                    // second case error
                    if(query.equalsIgnoreCase(word)) {
                        ans[i++] = word;
                        flag = true;
                        break;
                    }
                }
            }

            if(!flag){
                for(String word : wordlist){
                    String newWord = removeVowel(word);
                    String newQuery = removeVowel(query);

                    // third vowel error

                    if(newQuery.equalsIgnoreCase(newWord)){
                        ans[i++] = word;
                        flag = true;
                        break;
                    }
                }
            }

            if(!flag){
                ans[i++] = "";
            }

        }

        return ans;

    }

    public static String removeVowel(String s){
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){
            if(isVowel(c)){
                sb.append("*");
                continue;
            }

            sb.append(c);
        }

        return sb.toString();
    }

    public static boolean isVowel(char c){
        return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static String[] spellchecker2(String[] wordlist, String[] queries) {
        HashSet<String> set = new HashSet<>();
        HashMap<String, String> caseMap = new HashMap<>();
        HashMap<String, String> vowelMap = new HashMap<>();

        for(String word: wordlist){
            set.add(word);
            String lowerWord = word.toLowerCase();
            String deVowel = removeVowel(lowerWord);

            caseMap.putIfAbsent(lowerWord, word);
            vowelMap.putIfAbsent(deVowel, word);
        }
        int n = queries.length;
        String[] res = new String[n];

        for(int i = 0; i < n; i++){
            String q =  queries[i];
            if(set.contains(q)){
                res[i] = q;
            }
            else {
                String lowerWord = q.toLowerCase();
                String deVowel = removeVowel(lowerWord);

                if(caseMap.containsKey(lowerWord)) res[i] = caseMap.get(lowerWord);
                else if (vowelMap.containsKey(deVowel)) res[i] = vowelMap.get(deVowel);
                else res[i] = "";
            }

        }

        return res;
    }
}

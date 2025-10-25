package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Find_Resultant_Array_After_Removing_Anagrams {
    public static void main(String[] args) {

    }

    public List<String> removeAnagrams(String[] words) {
        int n = words.length;
        List<String> ans = new ArrayList<>();

        ans.add(words[0]);

        for (int i = 1; i < n; i++) {
            char[] a = words[i].toCharArray(), b = ans.getLast().toCharArray();

            Arrays.sort(a);
            Arrays.sort(b);
            if(!Arrays.equals(a,b)){
                ans.add(words[i]);
            }
        }

        return ans;
    }
}

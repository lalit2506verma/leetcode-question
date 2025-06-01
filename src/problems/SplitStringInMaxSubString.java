package problems;

import java.util.HashSet;
import java.util.Set;

public class SplitStringInMaxSubString {
    public static void main(String[] args) {
        String s = "wwwzfvedwfvhsww";

        System.out.println(maxUniqueSplit(s));
    }

    public static int maxUniqueSplit(String s) {
        Set<String> set = new HashSet<>();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j<s.length(); j++) {
                String str = s.substring(i, j + 1);

                if (!set.contains(str)) {
                    set.add(str);
                    count++;
                    i = j;
                    break;
                }
            }
        }
        for(String st:set){
            System.out.println(st);
        }
        return count;
    }
}

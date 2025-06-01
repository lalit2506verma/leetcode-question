package problems;

import java.util.HashMap;
import java.util.Map;

public class LongestSpecialSubstring1 {
    public static void main(String[] args) {
        HashMap<String, Integer> map = maximumLength("aaaba");

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " -- " + entry.getValue());
        }

    }

    public static HashMap maximumLength(String s) {
        int res = -1;
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                if(s.charAt(i) != s.charAt(j)){
                    break;
                }
                // extracting all the special substring -- "aaa"
                String sub = s.substring(i, j+1);
                if(map.containsKey(sub)){
                    map.put(sub, map.get(sub)+1);
                }
                else{
                    map.put(sub, 1);
                }

            }
        }
        return map;
    }
}

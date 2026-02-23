package problems;

import java.util.HashSet;

public class Check_If_a_String_Contains_All_Binary_Codes_of_Size_K {
    public static void main(String[] args) {

    }

    public boolean hasAllCodes(String s, int k) {
        HashSet<String> set = new HashSet<>();
        int n = s.length();
        int count = 1 << k;

        for(int i = 0; i < n; i++){
            String subStr = s.substring(i, i+k);
            if(!set.contains(subStr)){
                set.add(subStr);
                count--;
            }

            if(count == 0){
                return true;
            }
        }

        return false;
    }
}

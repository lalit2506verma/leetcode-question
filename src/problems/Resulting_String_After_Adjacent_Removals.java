package problems;

public class Resulting_String_After_Adjacent_Removals {
    public static void main(String[] args) {
        System.out.println(resultingString(""));
    }

    public static String resultingString(String s) {
        StringBuilder st = new StringBuilder();
        for(char c : s.toCharArray()){
            int size = st.length();
            if(!st.isEmpty() && isAdjacent(st.charAt(size -1), c)){
                st.deleteCharAt(size - 1);
            }
            else{
                st.append(c);
            }
        }

        return st.toString();
    }

    public static boolean isAdjacent(char chr1, char chr2){
        if((chr1 - chr2 + 26) % 26 == 1 || (chr2 - chr1 + 26) % 26 == 1) {
            return true;
        }
        return false;
    }
}

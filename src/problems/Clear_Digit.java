package problems;

public class Clear_Digit {
    public static void main(String[] args) {
        String s = "cbk34";
        System.out.println(clearDigit(s));
    }

    public static String clearDigit(String s){
        StringBuilder st = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))){  // not check whether there is char in the st beacuse it is gurantee that all didgit can be removed
                st.deleteCharAt(st.length()-1);
            }
            else{
                st.append(s.charAt(i));
            }
        }

        return st.toString();
    }
}

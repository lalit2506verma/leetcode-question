package problems;


public class Remove_All_Occurrence_Of_Substring {
    public static void main(String[] args) {
        String s = "daabcbaabcbc";
        String part = "abc";

        System.out.println(removeOccurrences(s, part));
    }

    public static String removeOccurrences(String s, String part) {
        StringBuilder st = new StringBuilder();

        int n = s.length();
        int m = part.length();

        for (int i = 0; i < n; i++) {
            st.append(s.charAt(i));

            if(st.length() >= m && checkSubstring(st, part, m)){
                st.delete(st.length() - m, st.length());
            }
        }

        return st.toString();
    }

    private static boolean checkSubstring(StringBuilder st, String part, int m) {
        return st.substring(st.length() - m, st.length()).equals(part);
    }
}

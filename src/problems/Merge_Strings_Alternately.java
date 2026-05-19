package problems;

public class Merge_Strings_Alternately {
    public static void main(String[] args) {

    }

    public static String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        StringBuilder sb = new StringBuilder(len1 + len2);

        int i = 0, j = 0;
        int idx = 0;
        while (i < len1 && j < len2) {
            if(idx % 2 == 0){
                sb.append(word1.charAt(i));
                i++;
            }
            else{
                sb.append(word2.charAt(j));
                j++;
            }
            idx++;
        }
        while(i < len1){
            sb.append(word1.charAt(i));
            i++;
        }

        while(j < len2){
            sb.append(word2.charAt(j));
            j++;
        }

        return sb.toString();
    }
}

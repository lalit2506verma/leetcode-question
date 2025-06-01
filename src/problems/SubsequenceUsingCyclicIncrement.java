package problems;

public class SubsequenceUsingCyclicIncrement {
    public static void main(String[] args) {
        String str1 =  "ab";
        String str2 = "d";
        System.out.println(canMakeSubsequence(str1, str2));
    }

    public static char nextCharacter(char c){

        if(c == 'z'){
            return 'a';
        }
        return (char) (c+1);
    }
    public static boolean canMakeSubsequence(String str1, String str2) {
        int i = 0; // pointer for str1
        int j = 0; // pointer for str2

        while(i < str1.length() && j < str1.length()){

            char nextChar = nextCharacter(str1.charAt(i));
            if(str1.charAt(i) == str2.charAt(j) || nextChar == str2.charAt(j)){
                i++;
                j++;
            }
            else{
                i++;
            }
        }

        return j >= str2.length();

    }
}

package problems;

public class Maximum_Number_of_Words_You_Can_Type {
    public static void main(String[] args) {

    }

    public int canBeTypedWords(String text, String brokenLetters) {
        int mask = 0;
        for (int i = 0; i < brokenLetters.length(); i++) {
            mask |= 1 << (brokenLetters.charAt(i) - 97);
        }

        int count = 0;
        for (int i = 0; i <= text.length(); i++) {
            boolean flag = false;
            if(i < text.length() && (mask & (1 << (text.charAt(i) - 97))) != 0){
                flag = true;
            }
            if(i == text.length() || text.charAt(i) == ' '){
                if(!flag) count++;
                flag = false;
            }
        }

        return count;
    }
}

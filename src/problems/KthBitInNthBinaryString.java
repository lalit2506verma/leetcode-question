package problems;

public class KthBitInNthBinaryString {
    public static void main(String[] args) {
        char res = findKthBit(3, 1);
        System.out.println(res);
    }

    public static String invert(String s){
        StringBuilder newStr = new StringBuilder();

        for(int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            if(c == '0'){
                newStr.append('1');
            }
            else{
                newStr.append('0');
            }
        }

        return newStr.reverse().toString();
    }
    public static char findKthBit(int n, int k) {
        String s = "0";
        for(int i = 1; i < n; i++){
            s = (s + "1").concat(invert(s));
            System.out.println(s);
        }

        return s.charAt(k);
    }
}

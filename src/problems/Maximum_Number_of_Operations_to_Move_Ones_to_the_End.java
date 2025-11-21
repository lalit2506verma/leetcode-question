package problems;

public class Maximum_Number_of_Operations_to_Move_Ones_to_the_End {
    public static void main(String[] args) {

    }

    public int maxOperations(String s) {
        int n = s.length();
        int ones = 0;
        int moves = 0;
        boolean flag = false;

        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '1'){
                ones++;
                flag = true;
            }
            else if(s.charAt(i) == '0' && flag){
                moves += ones;
                flag = false;
            }
        }

        return moves;
    }
}

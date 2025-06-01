package problems;

public class MaximumScoreAfterSplit {
    public static void main(String[] args) {
        String s = "11110000";
        System.out.println(maxScore(s));
    }

    public static int maxScore(String s) {
        int zeroCount = 0;
        int oneCount = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                oneCount++;
            }
        }

        int maxScore = 0;
        for(int i = 0; i < s.length()-1; i++){
            if(s.charAt(i) == '0'){
                zeroCount++;
            }
            else{
                oneCount--;
            }
            maxScore = Math.max(maxScore, zeroCount + oneCount);
        }
        return maxScore;
    }
}

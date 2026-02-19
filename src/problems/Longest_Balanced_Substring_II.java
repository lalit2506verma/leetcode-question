package problems;

public class Longest_Balanced_Substring_II {
    public static void main(String[] args) {
        String s = "aabcc";
        System.out.println(longestBalanced(s));
    }

    public static int longestBalanced(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int maxLen = 0;

        char currChar = 'z';
        int currCount = 0;
        int singleMaxCount = 0;

        for(int i = 0; i < n; i++){
            if(c[i] == currChar){
                currCount++;

            }
            else{
                currChar = c[i];
                currCount = 1;
            }
            singleMaxCount = Math.max(singleMaxCount, currCount);
        }
        maxLen = singleMaxCount;

        maxLen = Math.max(maxLen, find2(c, 'a', 'b'));
        maxLen = Math.max(maxLen, find2(c, 'b', 'c'));
        maxLen = Math.max(maxLen, find2(c, 'a', 'c'));

        maxLen = Math.max(maxLen, find3(c));

        return maxLen;

    }

    private static int find2(char[] c, char x, char y){
        int n = c.length, max_len = 0;
        int countX = 0, countY = 0;

        for(int i = 0; i < n; i++){
            if(c[i] == x){
                countX++;
            }
            else if(c[i] == y){
                countY++;
            }
            else{
                countX = 0;
                countY = 0;
            }

            if(countX == countY){
                max_len = Math.max(max_len, countX + countY);
            }
        }

        return max_len;
    }

    private static int find3(char[] c){
        int n = c.length, max_len = 0;
        int countX = 0, countY = 0, countZ = 0;

        for(int i = 0; i < n; i++){
            if(c[i] == 'a'){
                countX++;
            }
            else if(c[i] == 'b'){
                countY++;
            }
            else if(c[i] == 'c'){
                countZ++;
            }
            else{
                countX = 0;
                countY = 0;
                countZ = 0;
            }

            if(countX == countY && countY == countZ){
                max_len = Math.max(max_len, countX + countY + countZ);
            }
        }

        return max_len;
    }
}

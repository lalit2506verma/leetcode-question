package problems;

public class Number_of_ways_to_Split_String {
    static final int MOD = 1_000_000_007;
    public static void main(String[] args) {
        String s = "10101";
        System.out.println(numWays(s));
    }

    public static int numWays(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum  += Character.getNumericValue(s.charAt(i));
        }

        if (sum == 0) {
            int n = s.length();
            return (((n-1) * (n-2)) / 2) % MOD; // combination formula
        }

        if(sum % 3 != 0){
            return 0;
        }

        long onesEachPart = sum  / 3; // every part get 1/3 of the sum
        long part1 = 0, part2 = 0;
        sum = 0;

        for(char c : s.toCharArray()){
            if(c == '1'){
                sum++;
            }

            if(sum == onesEachPart){ // count 1 part have same as onesEachPart
                part1++;
            }
            if(sum == 2* onesEachPart) { // count paet 2  have same as onesEachPart
                part2++;
            }
        }
        return (int) ((part1 * part2) % MOD);
    }
}

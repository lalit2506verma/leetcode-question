package problems;

public class Find_Punishment_Number {
    static boolean flag = false;
    public static void main(String[] args) {
        int n = 10;
        System.out.println(punishmentNumber(n));
    }

    public static int punishmentNumber(int n) {
        int ans = 0;
        for (int num = 0; num <= n; num++) {
            int sqr = num * num;

            if(checkPunishment(sqr, num)){
                ans += sqr;
            }
        }

        return ans;
    }

    private static boolean checkPunishment(int sqr, int num) {
        String str = Integer.toString(sqr);

        check(str, num, 0, 0);

        return flag;
    }

    private static void check(String str, int target, int idx, int currSum) {
        if(currSum == target){
            flag = true;
            return;
        }
        if(currSum > target){
            return;
        }

        check(str.substring(idx), target, idx+1, currSum+Integer.parseInt(str.substring(0, idx)));
    }
}

package problems;

public class Find_the_Minimum_Amount_of_Time_to_Brew_Potions {
    public static void main(String[] args) {
        int[] skill = {1,5,2,4};
        int[] mana = {5,1,4,2};

        System.out.println(minTime(skill, mana));

    }

    public static long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;

        long[] finishTime = new long[n + 1];

        for(int p = 0; p < m; p++){
            for(int i = 1; i <= n; i++){
                finishTime[i] = Math.max(finishTime[i], finishTime[i-1]) + (long) skill[i-1] * mana[p];
            }

            for(int i = n-1; i > 0; i--){
                finishTime[i] = finishTime[i+1] - (long) skill[i] * mana[p];
            }
        }

        return finishTime[n];
    }
}

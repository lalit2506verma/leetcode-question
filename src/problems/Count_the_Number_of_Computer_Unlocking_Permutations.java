package problems;

public class Count_the_Number_of_Computer_Unlocking_Permutations {
    static int MOD = 1_000_000_007;
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(countPermutations(arr));
    }

    public static int countPermutations(int[] complexity) {
        int n = complexity.length;
        // check minimum and unique
        for(int i = 1; i < n; i++){
            if(complexity[0] >= complexity[i]){
                return 0;
            }
        }
        int ans = 1;
        // find the factorial of n-1
        for(int i = 1; i < n; i++){
            ans = (ans * i) % MOD;
        }

        return ans;
    }
}

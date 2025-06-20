package problems;

public class Count_the_Number_of_Arrays_with_K_Matching_Adjacent_Elements {
    static int MOD = 1_000_000_007;
    public static void main(String[] args) {

    }


    public int countGoodArrays(int n, int m, int k) {
        // C(n-1, n-1-k) * m * (m-1)^(n-1-k)
        int placeChoices = findCombination(n-1, n-1-k);
        int valueChoices = findPermutation(m-1, n-1-k);

        return 0;
    }

    private int findPermutation(int n, int r) {
        return 0;
    }

    private int findCombination(int n, int r) {
        return 0;
    }
}

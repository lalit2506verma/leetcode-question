package problems;

public class Count_the_hidden_sequence {
    public static void main(String[] args) {
        int[] arr = {1, -3, 4};
        System.out.println(numberOfArrays(arr, 1, 6));
    }

    public static int numberOfArrays(int[] differences, int lower, int upper) {
        int curr = 0;
        int maxVal = 0;
        int minVal = 0;

        for (int d : differences){
            curr = curr + d;

            minVal = Math.min(minVal, curr);
            maxVal = Math.max(maxVal, curr);

            if((upper-maxVal) - (lower - minVal) + 1 <= 0){
                return 0;
            }
        }

        return (upper-maxVal) - (lower - minVal) + 1;
    }
}

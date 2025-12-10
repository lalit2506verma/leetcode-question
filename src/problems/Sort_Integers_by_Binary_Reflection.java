package problems;

import java.util.Arrays;

public class Sort_Integers_by_Binary_Reflection {
    public static void main(String[] args) {

    }

    public int[] sortByReflection(int[] nums) {
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        Arrays.sort(arr, (a, b) -> {
            int ra = reflection(a);
            int rb = reflection(b);

            if(ra != rb){
                return Integer.compare(ra, rb);
            }
            return Integer.compare(a,b);
        });

        return Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
    }

    private int reflection(int x){
        String binary = Integer.toBinaryString(x);
        String reversed = new StringBuilder(binary).reverse().toString();
        return Integer.parseInt(reversed, 2);
    }
}

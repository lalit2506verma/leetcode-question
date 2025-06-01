package problems;

public class Subarray_with_given_XOR {
    public static void main(String[] args) {

    }
    public static int solve(int[] arr,int B){
        int count = 0;

        for(int i = 0; i < arr.length; i++){
            int xor = 0;
            for(int j = i; j < arr.length; j++){
                xor ^= arr[j];

                if(xor == B){
                    count++;
                }
            }
        }

        return count;
    }
}

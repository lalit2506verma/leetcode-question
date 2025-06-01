package problems;

public class Count_Symmetric_Integer {
    public static void main(String[] args) {
        System.out.println(countSymmetricIntegers(1, 100));
    }

    public static boolean checkSum(String num){
        int n = num.length();
        String firstHalf = num.substring(0, n/2);
        String secondHalf = num.substring(n/2);

        if(findSum(firstHalf) == findSum(secondHalf)){
            return true;
        }
        else{
            return false;
        }
    }

    public static int findSum(String num){
        int sum = 0;
        for(int i = 0; i < num.length(); i++){
            char c = num.charAt(i);

            sum += Character.getNumericValue(c);
        }
        return sum;
    }

    public static int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for(int i = low; i <= high; i++){
            String num = Integer.toString(i);

            if(num.length() % 2 != 0){
                continue;
            }

            if(checkSum(num)){
                count++;
            }
        }
        return count;
    }
}

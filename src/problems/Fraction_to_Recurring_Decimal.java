package problems;

import java.util.HashMap;

public class Fraction_to_Recurring_Decimal {
    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1, -1));
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0){
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        if ((numerator < 0) ^ (denominator < 0)) sb.append("-");

        int num = Math.abs(numerator);
        int den = Math.abs(denominator);

        // get the whole Number
        sb.append(num / den);
        int rem = num % den;

        if(rem == 0){
            return sb.toString();
        }

        // If rem is not zero then answer will go in decimal
        sb.append(".");
        // [rem, index it was added in hashmap]
        HashMap<Integer, Integer> integerMap = new HashMap<>();

        while(rem != 0){
            if(integerMap.containsKey(rem)){
                int index = integerMap.get(rem);
                sb.insert(index, "(");
                sb.append(")");
                break;
            }

            integerMap.put(rem, sb.length());
            rem *= 10;
            sb.append(rem / den);
            rem %= den;

        }

        return sb.toString();
    }
}

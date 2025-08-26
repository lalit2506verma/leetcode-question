package problems;

import java.util.ArrayList;
import java.util.List;

public class Game_24 {
    static double epsilon = 1e-6;
    public static void main(String[] args) {
        int[] cards = {8, 4, 1, 7};

        System.out.println(judgePoint24(cards));
    }
    
    public static boolean helper(List<Double> nums){
        // base case
        if(nums.size() == 1){
            return Math.abs(nums.getFirst() - 24) <= epsilon;
        }

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                // same card value can not be picked
                if(i == j){
                    continue;
                }

                List<Double> temp = new ArrayList<>();
                for (int k = 0; k < nums.size(); k++) {
                    if(k != i && k != j){
                        temp.add(nums.get(k));
                    }
                }

                double a = nums.get(i);
                double b = nums.get(j);
                ArrayList<Double> possibleVal = new ArrayList<>(
                        List.of(a+b, a-b, a*b, b-a)
                );

                if(b > 0.0){
                    possibleVal.add(a/b);
                }
                if(a > 0.0){
                    possibleVal.add(b/a);
                }

                for(double val : possibleVal){
                    temp.add(val); // do
                    if (helper(temp)){  // explore
                        return true;
                    }
                    temp.remove(val); // undo
                }
            }
        }
        return false;
    }

    public static boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for(int n : cards){
            nums.add((double)n);
        }

        return helper(nums);
    }
}

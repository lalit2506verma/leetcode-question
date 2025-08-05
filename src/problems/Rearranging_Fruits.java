package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Rearranging_Fruits {
    public static void main(String[] args) {
        int[] arr1 = {4,2,2,2};
        int[] arr2 = {1,4,1,2};

        System.out.println(minCost(arr1, arr2));
    }

    public static long minCost(int[] basket1, int[] basket2) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num: basket1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // for second basket
        for(int num : basket2){
            map.put(num, map.getOrDefault(num, 0) - 1);
        }

        ArrayList<Integer> list = new ArrayList<>();

        for(int key : map.keySet()){
            int value = Math.abs(map.get(key));
            // if overall freq is odd then it is impossible to equal both baskets
            if(value % 2 != 0){
                return -1;
            }

            for(int i = 0; i < value / 2; i++){
                list.add(value);
            }
        }

        Collections.sort(list);

        long cost = 0;
        int minElement = list.getFirst();

        for(int i = 0; i < list.size() / 2; i++){
            cost += Math.min(list.getFirst(), minElement*2);
        }

        return cost;
    }
}

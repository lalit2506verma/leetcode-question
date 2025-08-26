package problems;

import java.util.HashMap;

public class Fruit_Into_Baskets {
    public static void main(String[] args) {
        int[] arr = {1,2,3,2,2,3,3,2,1,1,2,3,3,2,2,1,1,3};
        System.out.println(totalFruit(arr));
    }

    public static int totalFruit(int[] fruits) {
        int maxLen = 0;
        int i = 0;
        int j = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while(j < fruits.length){
            // add
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);

            // remove
            while(map.size() > 2){
                map.put(fruits[i], map.get(fruits[i]) - 1);

                if(map.get(fruits[i]) == 0){
                    map.remove(fruits[i]);
                }
                i++;
            }

            // result calculate
            maxLen = Math.max(maxLen, j-i+1);
            j++;
        }

        return maxLen;
    }
}

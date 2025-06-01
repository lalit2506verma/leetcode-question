package problems;

import java.util.HashMap;
import java.util.Map;

public class Number_of_Equivalent_Domino_Pairs {
    public static void main(String[] args) {
        int[][] dominos = {{1,2},{2,1}, {3,4}, {5,6}};
        System.out.println(numEquivDominoPairs(dominos));
    }
// ===================== NEED TO ASK =================================

//    public static int numEquivDominoPairs(int[][] dominoes) {
//        Map<int[], Integer> freq = new HashMap<>();   // <Pair, freq>
//
//        for(int[] pair : dominoes){
//            int[] reversePair = new int[2];
//            reversePair[0] = pair[1];
//            reversePair[1] = pair[0];
//
//          freq.put(pair, freq.getOrDefault(pair, 0) + 1);
//            freq.put(pair, freq.getOrDefault(reversePair, 0) + 1);
//        }
//
//        int countEqui = 0;
//        for(Map.Entry<int[], Integer> map: freq.entrySet()){
//            int n = map.getValue();
//            if(n > 1){
//
//                countEqui += ((n * (n-1))/2);
//            }
//        }
//
//        return countEqui;
//    }

    public static int numEquivDominoPairs(int[][] dominoes) {
        int[] map = new int[100];

        for (int[] pair : dominoes){
            if(pair[0] > pair[1]) {
                map[pair[0] * 10 + pair[1]]++;
            }
            else{
                map[pair[1] * 10 + pair[0]]++;
            }
        }

        int count = 0;
        for(int freq : map){
            count += ((freq * (freq-1))/2);
        }

        return count;
    }
}

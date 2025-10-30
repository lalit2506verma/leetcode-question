package problems;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Sort_Characters_By_Frequency {
    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }

    public static String frequencySort(String s){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();

        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(char c : map.keySet()){
            pq.add(new int[]{(int)c, map.get(c)});
        }

        StringBuilder st = new StringBuilder();
        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            for(int i = 0; i < arr[1]; i++){
                st.append((char) arr[0] );
            }
        }

        return st.toString();
    }
}

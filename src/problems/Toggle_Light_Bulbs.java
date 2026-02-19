package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Toggle_Light_Bulbs {
    public static void main(String[] args) {
        List<Integer> list = List.of(10, 20, 30, 10);
        System.out.println(toggleLightBulbs(list));
    }

    public static List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        int n = bulbs.size();

        HashSet<Integer> setOn = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(setOn.contains(bulbs.get(i))){
                // remove
                setOn.remove(bulbs.get(i));
                list.remove(bulbs.get(i));
            }
            else{
                setOn.add(bulbs.get(i));
                list.add(bulbs.get(i));
            }

        }

        Collections.sort(list);

        return list;
    }
}

package problems.ImplementationClasses;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class NumberContainers {
    Map<Integer, Integer> map;
    Map<Integer, SortedSet<Integer>> idx;  // {number, (idx in sorted) }

    public NumberContainers() {
        map = new HashMap<>();
        idx = new HashMap<>();
    }

    public void change(int index, int number) {
        // If the number is not present in the Idx map then add the number with instance of SortedSet
        if(!idx.containsKey(number)){
            idx.put(number, new TreeSet<>());
        }

        // If present then add the idx in the map


    }

    public int find(int number) {
        return 0;
    }
}

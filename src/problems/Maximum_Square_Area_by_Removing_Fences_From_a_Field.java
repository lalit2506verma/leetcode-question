package problems;

import java.util.*;

public class Maximum_Square_Area_by_Removing_Fences_From_a_Field {
    int MOD = 1_000_000_000 + 7;
    public static void main(String[] args) {

    }

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int h = hFences.length;
        int v = vFences.length;

        int[] hList = Arrays.copyOf(hFences, h + 2);
        hList[h] = 1;
        hList[h + 1] = m;

        int[] vList = Arrays.copyOf(vFences, v + 2);
        vList[v] = 1;
        vList[v + 1] = n;

        Arrays.sort(hList);
        Arrays.sort(vList);

        Set<Integer> hGaps = new HashSet<>();
        for(int i = 0; i < h+2; i++){
            for(int j = i+1; j < h+2; j++){
                hGaps.add(hList[j] -  hList[i]);
            }
        }

        int maxSide = -1;
        for(int i = 0; i < v+2; i++){
            for(int j = i+1; j < v+2; j++){
                int currentGap = vList[j] - vList[i];
                if(hGaps.contains(currentGap)){
                    maxSide = Math.max(maxSide, currentGap);
                }
            }
        }

        if(maxSide == -1) return -1;

        return (maxSide * maxSide) % MOD;
    }


}

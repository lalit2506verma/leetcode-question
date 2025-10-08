package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Avoid_Flood_in_The_City {
    public static void main(String[] args) {
        int[] rains = {1,0,2,0,3,0,2,0,0,0,1,2,3};
        System.out.println(Arrays.toString(avoidFlood(rains)));
    }

    public static int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] res  = new int[n];

        List<Integer> zeroIdx = new ArrayList<>();
        HashMap<Integer, int[]> freq = new HashMap<>();

        for (int i = 0; i < n; i++) {
            // If dry day
            if(rains[i] == 0){
                zeroIdx.add(i);
                res[i] = 1;
                continue;
            }

            // rain happen
            // Check for duplicate
            if(!freq.containsKey(rains[i])){
                res[i] = -1;
                freq.put(rains[i], new int[]{1, i} );
                continue;
            }

            // Here Duplicate exists
            if(zeroIdx.isEmpty()){
                return new int[]{};
            }

            int[] temp = freq.get(rains[i]);
            int nearestZeroIdx = binarySearch(zeroIdx, temp[1]);
            temp[1] = i;
            if(nearestZeroIdx > -1){
                res[zeroIdx.get(nearestZeroIdx)] = rains[i];
                zeroIdx.remove(nearestZeroIdx);
                res[i] = -1;
            }
            else{
                return new int[]{};
            }
        }

        return res;
    }

    private static int binarySearch(List<Integer> zeroIdx, int target) {
        int s = 0;
        int e =  zeroIdx.size()-1;
        int res = -1;
        while(s <= e){
            int mid = s + (e - s) / 2;

            if(zeroIdx.get(mid) > target){
                res = mid;
                e = mid - 1;
            }
            else {
                s = mid + 1;
            }
        }

        return res;
    }
}

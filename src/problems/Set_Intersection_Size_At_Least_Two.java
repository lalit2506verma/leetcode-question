package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Set_Intersection_Size_At_Least_Two {
    public static void main(String[] args) {
        int[][] intervals = {{54,766},{159,390},{971,1000},{865,930},{583,665},{579,601},{931,941},{741,788},{280,625},{863,880},{673,824},{924,973}};
        System.out.println(intersectionSizeTwo(intervals));
    }

    public static int intersectionSizeTwo(int[][] intervals) {
        int lastEle1 = -1;
        int lastEle2 = -1;

        // sorting the list
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int ans = 0;

        for(int[] interval : intervals){
            int start = interval[0];
            int end = interval[1];


            if(start > lastEle2){
                ans += 2;
                lastEle1 = end - 1;
                lastEle2 = end;
            }

            if(lastEle2 >= start && lastEle2 <= end){
                if(!(lastEle1 >= start && lastEle1 <= end)){
                    if(lastEle2 != end){
                        ans += 1;
                        lastEle1 = lastEle2;
                        lastEle2 = end;
                    }
                    else{
                        ans += 1;
                        lastEle1 = end - 1;
                    }
                }
            }

        }
        return ans;
    }
}

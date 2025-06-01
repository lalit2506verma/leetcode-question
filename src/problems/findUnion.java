package problems;

import java.util.ArrayList;

public class findUnion {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3};
        System.out.println(findUnion1(arr1, arr2));
    }

    public static ArrayList<Integer> findUnion1(int arr1[], int arr2[]) {
        ArrayList<Integer> list = new ArrayList<>();
        int pt1 = 0;
        int pt2 = 0;

        while(pt1 < arr1.length && pt2 < arr2.length){
            //case 1 and 2

            if(arr1[pt1] <= arr2[pt2]){
                if(list.isEmpty() || list.getLast() != arr1[pt1]){
                    list.add(arr1[pt1]);
                }
                pt1++;
            }
            //case 3
            else {
                if(list.isEmpty() || list.getLast() != arr2[pt2]){
                    list.add(arr2[pt2]);
                }
                pt2++;
            }
        }

        // If any of the array still left
        while(pt1 < arr1.length){
            if(list.getLast() != arr1[pt1]){
                list.add(arr1[pt1]);
            }
            pt1++;
        }

        while(pt2 < arr2.length){
            if(list.getLast() != arr2[pt2]){
                list.add(arr2[pt2]);
            }
            pt2++;
        }

        return list;
    }
}

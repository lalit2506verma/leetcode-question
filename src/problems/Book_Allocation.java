package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Book_Allocation {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(25, 46, 28, 49, 24));
        int n = 5;
        int m = 4;
        int ans = findPages(arr, n, m);
        System.out.println("The answer is: " + ans);
    }

    // m -> No. of student
    // n -> No. of books
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // Impossible Allocation
        if(m > n){
            return -1;
        }

        int low = Collections.max(arr);
        int high = 0;

        int len = arr.size();
        for (int i = 0; i < n; i++) {
            high += arr.get(i);
        }

        // loop from low to high -> maxElement to sum  of the array
        for (int pages = low; pages <= high; pages++) {
            if(countStudent(arr, pages) == m){
                return pages;
            }
        }
        return low;

    }

    private static int countStudent(ArrayList<Integer> arr, int pages) {
        int studentCount = 1;
        int studentPages = 0;

        int n = arr.size();

        for (int i = 0; i < n; i++) {
            if(studentPages + arr.get(i) <= pages){
                studentPages += arr.get(i);
            }
            else{
                studentPages = arr.get(i);
                studentCount++;
            }
        }

        return studentCount;
    }
}

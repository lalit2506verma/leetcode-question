package problems;

import java.util.LinkedList;
import java.util.Queue;

public class Number_of_Students_Unable_to_Eat_Lunch {
    public static void main(String[] args) {

    }

    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;
        int[] count = new int[2];

        for (int student : students) {
            if(student == 0){
                count[0]++;
            }
            else{
                count[1]++;
            }
        }

        int i = 0;
        while(count[sandwiches[i]] > 0){
            count[sandwiches[i]]--;
            i++;
        }

        return n-i-1;
    }
}

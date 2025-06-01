package problems;

import java.util.Scanner;

public class Tower_of_Hanoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printSteps(n, 'A', 'C', 'B');
    }

    public static void printSteps(int n,char src,char dest,char help){

        //Base case
        if(n==0){
            return;
        }
        //Moving n-1 disk from src to help
        printSteps(n-1,src,help,dest);
        System.out.println("Move "+n+" from "+src+" to "+dest);
        printSteps(n-1,help,dest,src);
    }
}

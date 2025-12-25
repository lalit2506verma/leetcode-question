package problems;

import java.util.Scanner;

public class Valid_Parenthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t--> 0) {
            String s = sc.nextLine();

            // 		Stack<Character> stack = new stack<>();
            int count = 0;

            for (char c: s.toCharArray()) {
                if (c == '(') {
                    count++;
                }
                else {
                    count--;
                }

                if (count < 0) {
                    System.out.println("0");
                    break;
                }
            }

            if (count != 0) {
                System.out.println("0");
            } else {
                System.out.println("1");
            }
        }

    }

}

package problems;

import java.util.Stack;

public class Count_Collisions_on_a_Road {
    public static void main(String[] args) {
        System.out.println(countCollisions("LRSLRS"));
    }

    public static int countCollisions(String directions) {
        int n = directions.length();
        Stack<Character> stack = new Stack<>();
        int collisions = 0;

        for(char dir : directions.toCharArray()){
            if(stack.isEmpty()){
                stack.push(dir);
                continue;
            }

            if(dir == 'R'){
                // R direction can collide later with S
                stack.push('R');
            }
            else if(dir == 'S'){
                // checking R direction collision
                while(!stack.isEmpty() && stack.peek() == 'R'){
                    stack.pop();
                    collisions++;
                }
                stack.push('S');
//                if(stack.isEmpty() || stack.peek() == 'S'){
//
//                }
            }
            else { // dir = L
                if(stack.peek() == 'R'){
                    // double collision
                    stack.pop();
                    collisions+=2;
                    // Now more R before this collision can be
                    while(!stack.isEmpty() && stack.peek() == 'R'){
                        stack.pop();
                        collisions++;
                    }
                    stack.push('S');
//                    if(stack.isEmpty() || stack.peek() == 'S'){
//
//                    }
                }

                else if(stack.peek() == 'S'){
                    collisions++;
                }
                else{
                    stack.push('L');
                }
            }
        }

        return collisions;
    }
}

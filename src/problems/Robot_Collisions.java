package problems;

import java.util.*;

public class Robot_Collisions {
    public static void main(String[] args) {
        int[] pos = {3,5,2,6};
        int[] health = {10,10,15,12};
        List<Integer> list = survivedRobotsHealths(pos, health, "RLRL");

        System.out.println(list);
    }

    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        int[][] directionMatrix = new int[n][2]; // [linePosition, arrayPosition]

        for (int i = 0; i < n; i++) {
            directionMatrix[i] = new int[]{positions[i], i};
        }

        Arrays.sort(directionMatrix, Comparator.comparingInt(a -> a[0]));

        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int newIdx = directionMatrix[i][1];
            char newDir = directions.charAt(newIdx);

            boolean alive = true;
            while (!stack.isEmpty() && alive) {
                int[] prev = stack.peek();
                int prevIdx = prev[1];
                char prevDir = directions.charAt(prevIdx);

                // Only collide if prev is R and new is L
                if (prevDir == 'R' && newDir == 'L') {
                    if (healths[prevIdx] == healths[newIdx]) {
                        healths[prevIdx] = 0;
                        healths[newIdx] = 0;
                        stack.pop();
                        alive = false;
                    } else if (healths[prevIdx] > healths[newIdx]) {
                        healths[prevIdx] -= 1;
                        healths[newIdx] = 0;
                        alive = false;
                    } else {
                        healths[prevIdx] = 0;
                        healths[newIdx] -= 1;
                        stack.pop(); // prev destroyed, keep checking with next
                    }
                } else {
                    break; // no collision
                }
            }

            if (alive) {
                stack.push(directionMatrix[i]);
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(healths[i] != 0){
                list.add(healths[i]);
            }
        }

        return list;

    }
}

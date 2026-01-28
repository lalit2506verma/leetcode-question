package problems;

import java.util.Arrays;
import java.util.Stack;

public class Largest_Rectangle_in_Histogram {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea2(heights));
    }

    // Brute force
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] nse = findNse(heights);
        int[] pse = findPse(heights);

        int maxArea = 0;
        for(int i = 0; i < n; i++) {
            int area = heights[i] * (nse[i] - pse[i] - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    private static int[] findPse(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        Arrays.fill(res, -1);

        for (int i = n-1; i >= 0; i--) {
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                res[stack.pop()] = i;
            }
            stack.push(i);
        }

        return res;
    }

    private static int[] findNse(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];

        Arrays.fill(res,n);

        for (int i = 0; i < n; i++){
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                res[stack.pop()] = i;
            }
            stack.push(i);
        }
        return res;
    }

    public static int largestRectangleArea2(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();

        int maxArea = 0;

        for(int i = 0; i < n; i++){
            int nse = n;
            int pse = -1;
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                int elem = st.pop();
                nse = i;
                pse = st.isEmpty() ? -1 : st.peek();

                maxArea = Math.max(maxArea, heights[elem] * (nse - pse - 1));
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int nse = n;
            int element = st.pop();
            int pse =  st.isEmpty() ? -1 : st.peek();
            maxArea = Math.max(maxArea, heights[element] * (nse - pse - 1));
        }

        return maxArea;
    }

}


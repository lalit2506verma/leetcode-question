package problems;

import java.util.*;

// https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level/?envType=daily-question&envId=2024-12-23
public class NoOfOpsToSortBinaryTree {
    public static void main(String[] args) {

    }

    public int countOpsToSort(ArrayList<Integer> list){
        int swaps = 0;
        ArrayList<Integer> sortedArray = new ArrayList<>();
        HashSet<Integer> map = new HashSet<>();

        return swaps;
    }

    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int count = 0;

        while(!que.isEmpty()){
            int n = que.size();

            ArrayList<Integer> list = new ArrayList<>();
            int i = 0;
            while(n > 0){
                TreeNode temp = que.peek();
                que.poll();
                list.add(temp.val);

                if(temp.left != null){
                    que.add(temp.left);
                }

                if(temp.right != null){
                    que.add(temp.right);
                }
                n--;
            }

            count += countOpsToSort(list);
        }

        return count;
    }

}

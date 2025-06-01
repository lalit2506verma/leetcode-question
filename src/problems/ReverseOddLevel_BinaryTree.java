package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ReverseOddLevel_BinaryTree {
    public static void main(String[] args) {

    }

    public static TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int level = 0;

        while(!que.isEmpty()){
            int n = que.size(); // size of every level

            ArrayList<TreeNode> levelNodes = new ArrayList<>();
            // Add all the values of the next level in the queue
            while(n > 0){
                TreeNode temp = que.peek();
                que.poll();
                levelNodes.add(temp);
                if(temp.left != null){
                    que.add(temp.left);
                }

                if(temp.right != null){
                    que.add(temp.right);
                }
                n--;
            }

            // Now we have all the nodes of the same level

            if(level % 2 != 0){ // odd levels
                // reverse the node level array
                int i = 0;
                int j = levelNodes.size()-1;
                while(i < j){
                    int temp = levelNodes.get(i).val;
                    levelNodes.get(i).val = levelNodes.get(j).val;
                    levelNodes.get(j).val = temp;
                    i++;
                    j--;
                }
            }
            level++;
        }
        return root;
    }
}

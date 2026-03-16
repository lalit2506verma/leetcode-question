package problems;

import java.util.LinkedList;
import java.util.Queue;

public class Sum_of_Root_To_Leaf_Binary_Numbers {
    public static void main(String[] args) {

    }

    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode node, int curr){
        if(node == null) return 0;

        curr = (curr << 1) | node.val;

        if (node.left == null && node.right == null) {
            return curr;
        }

        return dfs(node.left, curr) + dfs(node.right, curr);
    }

}

package problems;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Maximum_Level_Sum_of_a_Binary_Tree {
    public static void main(String[] args) {

    }

    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int maxLevelSum = Integer.MIN_VALUE;
        int maxLevel = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode node = queue.poll();

            int levelSum = 0;
            for (int i = 0; i < size; i++) {
                levelSum += node.val;

                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }

            if(levelSum > maxLevelSum) {
                maxLevelSum = levelSum;
                maxLevel = size;
            }
        }

        return maxLevel;
    }
}

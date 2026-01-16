package problems;

public class Smallest_Subtree_with_all_the_Deepest_Nodes {
    int maxDepth = 0;

    public static void main(String[] args) {

    }

    public int getMaxDepth(TreeNode root) {
        if (root == null) return 0;

        return Math.max(getMaxDepth(root.left), getMaxDepth(root.right)) + 1;
    }

    public TreeNode helper(TreeNode node, int currentDepth){
        if (node == null) return null;
        if(currentDepth == maxDepth-1){
            return node;
        }

        TreeNode left = helper(node.left, currentDepth+1);
        TreeNode right = helper(node.right, currentDepth+1);

        if(left != null && right != null){
            return node;
        }

        return left == null ? right : left;
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        maxDepth = getMaxDepth(root);
        return helper(root, 0);
    }
}

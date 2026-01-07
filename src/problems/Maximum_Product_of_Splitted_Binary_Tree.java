package problems;

public class Maximum_Product_of_Splitted_Binary_Tree {
    static int MOD = 1000000007;
    static long maximumProduct = 0;
    static long totalSum = 0;
    public static void main(String[] args) {

    }

    public int totalSum(TreeNode node){
        if(node == null) return 0;

        return totalSum(node.left) + totalSum(node.right) + node.val;
    }

    public long helper(TreeNode node){
        if(node == null) return 0;

        long subTreeSum = helper(node.left) + helper(node.right) + node.val;
        maximumProduct = Math.max(maximumProduct, (totalSum - subTreeSum) * subTreeSum);

        return subTreeSum;
    }

    public int maxProduct(TreeNode root) {
        totalSum = totalSum(root);

        helper(root);

        return (int) (maximumProduct % MOD);
    }
}

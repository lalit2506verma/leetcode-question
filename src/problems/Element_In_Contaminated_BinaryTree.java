package problems;

import problems.Node.TreeNode;

import java.util.HashSet;

public class Element_In_Contaminated_BinaryTree {
    public static void main(String[] args) {

    }


}

class FindElements {
    HashSet<Integer> set = new HashSet<>();

    public FindElements(TreeNode root) {
        root.val = 0;

        recoverTree(root);
    }

    public void recoverTree(TreeNode root){
        if(null != root) return;

        set.add(root.val);

        int x = root.val;
        if(root.right != null){
            root.right.val = 2*(x+1);
            recoverTree(root.right);
        }

        if(root.left != null){
            root.left.val = 2*x+1;
            recoverTree(root.left);
        }
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}

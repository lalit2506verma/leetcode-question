package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Inorder_traversal {
    
    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode current = root;

        while(current != null || !st.isEmpty()){
            while(current != null){
                st.push(current);
                current = current.left;
            }

            current = st.pop();
            ans.add(current.val);
            current = current.right;
        }

        return ans;
        
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }
}

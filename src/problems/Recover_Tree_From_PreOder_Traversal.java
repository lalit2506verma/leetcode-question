package problems;

public class Recover_Tree_From_PreOder_Traversal {
    private String s;
    private int idx, level;
    public static void main(String[] args) {


    }


    public TreeNode recoverFromPreorder(String traversal) {
        s = traversal;
        idx = 0;
        level = 0;

        //dummy node
        TreeNode node = new TreeNode(-1);
        helper(node, 0);
        return node.left;
    }

    public void helper(TreeNode parent, int lvl){
        while(idx < s.length() && lvl == level){
            int num = 0;
            while(idx < s.length() && Character.isDigit(s.charAt(idx))){
                num = num * 10 + (s.charAt(idx++) - '0');
            }

            TreeNode node = new TreeNode(num);
            if(parent.left == null){
                parent.left = node;
            }
            else{
                parent.right = node;
            }

            // level
            level = 0;
            while(idx < s.length() && s.charAt(idx) == '-'){
                level++;
                idx++;
            }

            helper(node, lvl+1);
        }
    }
}

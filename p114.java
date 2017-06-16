package leetcode2;

/**
 * Created by wy on 2017/6/16.
 */
public class p114 {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    public void flatten(TreeNode root) {
        if(root==null)
            return;
        flat(root);
    }
    TreeNode flat(TreeNode root){
        if(root==null)
            return null;
        TreeNode left=root.left;
        TreeNode right=root.right;
        root.right=flat(root.left);
        root.left=null;
        // 获得最右边的node
        TreeNode temp=root;
        TreeNode last=null;

        while (temp!=null){
            last=temp;
            temp=temp.right;
        }
        last.right=flat(right);
        return root;
    }



}

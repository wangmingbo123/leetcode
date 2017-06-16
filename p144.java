package leetcode2;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wy on 2017/6/16.
 */
public class p144 {
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
     }
    public List<Integer> preorderTraversal(TreeNode node) {
        List<Integer> list = new LinkedList<Integer>();
        Stack<TreeNode> stack=new Stack<TreeNode>();
        while (node!=null){
//             stack.add(node);

//             System.out.println(node.val+" ");
            list.add(node.val);
            if(node.right!=null)
                stack.push(node.right);
            node=node.left;
            if(node==null&& !stack.empty())
                node=stack.pop();
        }

        return list;
    }
}

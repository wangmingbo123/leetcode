package leetcode2;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wy on 2017/6/16.
 */
public class p94 {

     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        Stack<TreeNode> stack=new Stack<TreeNode>();
        while (root!=null|| !stack.empty()){
            if(root!=null){
                stack.push(root);
                root=root.left;
                   /*  if(!stack.empty()){
                         root=stack.pop();
                     }*/

            }else{
                if(!stack.empty()){
                    root=stack.pop();
                    // visit
                    list.add(root.val);

                    // right
                    root=root.right;
                    // 做一个为null判断
                       /*  if(!stack.empty()){
                             root=stack.pop();
                         }*/

                }
            }
        }
        return list;
    }
}

package leetcode2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by wy on 2017/6/14.
 */
public class p515 {
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        List<Integer> list=new ArrayList<Integer>();
        if(root!=null)
        queue.offer(root);
        int quenueSize=queue.size();
        while (quenueSize>0){
              int min=Integer.MIN_VALUE;
              for(int i=0;i<quenueSize;i++){
                  TreeNode temp=queue.poll();
                  min=Math.max(min,temp.val);
                  if(temp.left!=null)
                  queue.offer(temp.left);
                  if(temp.right!=null)
                  queue.offer(temp.right);
              }
              list.add(min);
              quenueSize=queue.size();
        }
        return list;


    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    // method 2  dfs




}

package leetcode2;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wy on 2017/6/14.
 */
public class p513 {
    public class TreeNode {
        int val;
        TreeNode  left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    @Test
    public void haha(){

//            findBottomLeftValue();

    }
    // bfs
    public int findBottomLeftValue(TreeNode root) {
           int leftmost=0;
           Queue<TreeNode> queue=new LinkedList<TreeNode>();
           if(root!=null){
               queue.offer(root);
           }
           int size=queue.size();
           while (size>0){
                 for(int i=0;i<size;i++){
                     TreeNode temp=queue.poll();
                     if(i==0)
                         leftmost=temp.val;
                     if(temp.left!=null){
                         queue.offer(temp.left);
                     }
                     if(temp.right!=null){
                         queue.offer(temp.right);
                     }
                 }
               size=queue.size();
           }
           return size;
    }

    // dfs
    HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
    void test(TreeNode root,int depth){

        if(root==null)
            return ;
        Integer value=map.get(depth+1);
        if(value==null)
           map.put(depth+1,root.val);
        test(root.left,depth+1);
        test(root.right,depth+1);
    }


}

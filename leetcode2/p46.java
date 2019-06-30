package leetcode2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wy on 2017/6/16.
 */
public class p46 {
    public List<List<Integer>> permute(int[] nums) {
        int n=nums.length;
//           List<List<Integer>> all=new ArrayList<List<Integer>>();
        HashMap<Integer,List<List<Integer>>> map=new HashMap<Integer, List<List<Integer>>>();
        List<List<Integer>> zero=new ArrayList<List<Integer>>();
        List<Integer> list=new ArrayList<Integer>();
        list.add(nums[0]);
        zero.add(list);
        map.put(1,zero);
        for(int i=2;i<=n;i++){
            // 上一级
//               List<Integer> one=all.get(i-1);
            List<List<Integer>> hang=map.get(i-1);
            List<List<Integer>> newHang=new ArrayList<List<Integer>>();
            for(List<Integer> item:hang){
                // 要放的元素是
                Integer data=nums[i-1];
//                   List<Integer> haha=new ArrayList<Integer>();
                for(int j=0;j<i;j++){
                    //
                    item.add(j,data);
                    // high 不包括
                    List<Integer> haha=new ArrayList<Integer>(item);
                    newHang.add(haha);
                    item.remove(j);
                }
            }
            map.put(i,newHang);
        }
        return  map.get(n);
    }
}

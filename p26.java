package leetcode2;

/**
 * Created by wy on 2017/6/15.
 */
public class p26 {
    // 将原来的数组消去重复
    // n 用于记录不同元素的下标
    public int removeDuplicates(int[] nums) {
           if(nums.length==0)
               return 0;
           int n=1;
           for(int i=1;i<nums.length;i++){
               if(nums[i-1]!=nums[i]){
                   nums[n]=nums[i];
                   n++;
               }
           }
           return n;
    }
}

package leetcode2;

/**
 * Created by wy on 2017/6/17.
 */
public class p35 {
    public int searchInsert(int[] nums, int target) {
           int l=0;
           int r=nums.length-1;
           while (l<=r){
                 int m=(l+r)/2;
                 if(nums[m]==target)
                     return m;
                 if(target<nums[m]){
                     r=m-1;
                     if(l>r){
                         return m;
                     }
                 }
                 if(target>nums[m]){
                     l=m+1;
                     if(l>r){
                         return m;
                     }

                 }
           }
           return 0;
    }

}

package leetcode2;

/**
 * Created by wy on 2017/6/14.
 */
public class p75 {
    public void sortColors(int[] nums) {
           int l=0;
           int m=0;
           int r=0;
           for(int k=0;k<nums.length;k++){
               if(nums[k]==0)
                   l++;
               else if(nums[k]==1)
                   m++;
               else
                   r++;
           }
           for(int k=0;k<nums.length;k++){
               if (k<l)
                   nums[k]=0;
               else if(k<l+m)
                   nums[k]=1;
               else
                   nums[k]=2;
           }

    }
}

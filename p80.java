package leetcode2;

/**
 * Created by wy on 2017/6/15.
 */
public class p80 {
    // double index
    //一个记录符合要求的
    // 一个记录当前的
    public int removeDuplicates(int[] nums) {
           if(nums.length==0)
               return 0;
           int n=1;
           int time=0;
           for(int i=1;i<nums.length;i++){
               if(nums[i-1]!=nums[i]){
                   if(time==2){
                   nums[n]=nums[i];
                   n++;
                   time=0;
                   }
               }else {
                   if(time<2)
                       n++;
                   time++;

               }


           }
           return n;
    }
}

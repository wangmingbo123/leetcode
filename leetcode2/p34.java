package leetcode2;


/**
 * Created by wy on 2017/6/17.
 */
public class p34 {
    public  void test(){
            int nums[]={5,7,7,8,8,10};
            searchRange(nums,8);
    }

    int inleft=-1;
    int inright=-1;
    boolean leftOrright=true;
    // 两次二分
    // 将复杂操作进行拆分
    public int[] searchRange(int[] nums, int target) {
           int left=0;
           int right=nums.length-1;

           binleft(left,right,nums,target);
           int res[]={inleft,inright};
           return  res;
    }
    public void binleft(int left,int right,int a[],int target){
           if(left>right)
               return;
           int midddle=(left+right)/2;
           if(target==a[midddle]){
               if(leftOrright){
               inleft=midddle;
               binleft(left,midddle-1,a,target);
               }else {
                   inright=midddle;
                   binleft(midddle+1,right,a,right);
               }
           }
           if(target<a[midddle])
               binleft(left,midddle-1,a,target);
           if(target>a[midddle])
               binleft(midddle+1,right,a,target);
    }

    // method2 迭代
    public int[] two(int a[],int target){
           int left=0;
           int right=a.length-1;
           //左边界
           while (left<=right){
                  int middle=(left+right)/2;
                  if(target==a[middle]){
                      inleft=middle;
                      right=middle-1;
                  }else if(target>a[middle]){
                      left=middle+1;
                  }else {
                      right=middle-1;
                  }
           }

        while (left<=right){
            int middle=(left+right)/2;
            if(target==a[middle]){
                inright=middle;
                left=middle+1;
            }else if(target>a[middle]){
                left=middle+1;
            }else {
                right=middle-1;
            }
        }
        int res[]={inleft,inright};
        return  res;
    }








}

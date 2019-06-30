package leetcode2;

import java.util.Arrays;

/**
 * Created by wy on 2017/6/14.
 */
public class p11 {
       // vertical line 垂直的线
       public int maxArea(int[] height) {
              int max=Integer.MIN_VALUE;
              for(int i=0;i<height.length;i++){
                  for(int j=i+1;j<height.length;j++){
                      int reuslt=Math.min(height[i],height[j])*(j-i);
                      max=Math.max(max,reuslt);
                  }

              }
              return max;
       }


    // wrong idea
    public int maxArea1(int[] height) {
        Arrays.sort(height);
        int max=Integer.MIN_VALUE;
        int i=0;
        int j=height.length-1;
        while (i<j){
              int result=(j-i)*height[j];
              max=Math.max(result,max);
              i++;
              j--;
        }
        return max;
    }


    public int maxArea2(int[] height) {
           int i=0;
           int j=height.length-1;
           int max=Integer.MIN_VALUE;
           while (i<j){
               int reuslt=Math.min(height[i],height[j])*(j-i);
               max=Math.max(max,reuslt);
               if(height[i]>height[j]) {
                   j--;// i fixed
               }else {
                   i++;
               }
           }
           return max;
    }



}

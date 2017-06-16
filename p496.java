package leetcode2;

/**
 * Created by wy on 2017/6/16.
 */
public class p496 {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {

        int reuslt[]=new int[findNums.length];
        for(int m=0;m<reuslt.length;m++)
            reuslt[m]=-1;
        for(int i=0;i<findNums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(findNums[i]==nums[j]){
                    // find the fisrt great number
                    for(int k=j+1;k<nums.length;k++){
                        if(findNums[i]<nums[k]){
                            reuslt[i]=nums[k];
                            break;
                        }
                    }
                }
            }
        }
        return reuslt;
    }

}

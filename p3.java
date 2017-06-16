package leetcode2;

import java.util.HashMap;

/**
 * Created by wy on 2017/6/15.
 */
public class p3 {
    // first 记录左边界
    // i 遍历,右边界
    // 当s.charAt(i)在(0-i)存在时,位置为j,且j>=first是，需要更新first
    // 每次更新i字符所在的位置

    // 优化，如何===《当s.charAt(i)在(0-i)存在时》这一步的效率


    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)
            return 0;
        int left=0;
        int len=1;
        HashMap<String,Integer> map=new HashMap<String, Integer>();
        //map.put(s.charAt(0)+"",0);
        for(int i=0;i<s.length();i++){
            Integer index=map.get(s.charAt(i)+"");
            if(index!=null&&index>=left){
                // 更新左指针
                left=index+1;


            }
            // 比较len的长度
            len=Math.max(len,i-left+1);
            // 更新字符的新位置
            map.put(s.charAt(i)+"",i);

        }
        return len;
    }
}

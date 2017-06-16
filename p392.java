package leetcode2;

/**
 * Created by wy on 2017/6/16.
 */
public class p392 {
    public boolean isSubsequence(String s, String t) {
        int ss=0;
        int tt=0;
        boolean flag=true;
        while (ss<s.length()){
            int temp=ss;
            while (tt<t.length()){
                if(s.charAt(ss)==t.charAt(tt)){
                    ss++;
                    tt++;
                    break;
                }else {
                    tt++;
                }
            }
            if(temp==ss){
                flag=false;
                break;
            }

        }
        return flag;
    }
}

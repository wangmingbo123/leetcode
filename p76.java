package leetcode2;

import org.junit.Test;

/**
 * Created by wy on 2017/6/14.
 */
public class p76 {

    @Test
    public void test(){
           String s="ADOBECODEBANC";
           String t="ABC";
           minWindow(s,t);
    }

    public String minWindow(String S, String T) {
        if(S==null||S.length()==0||T==null||T.length()==0) return "";
        int i=0, j=0;
        int[] Tmap=new int[256];
        int[] Smap=new int[256];
        for(int k=0; k< T.length(); k++){
            // 第k个字符
            int num=T.charAt(k);
            Tmap[num]++;
        }
        int found=0;
        int length=Integer.MAX_VALUE;
        String res="";
        while(j<S.length()){
            if(found<T.length()){
                if(Tmap[S.charAt(j)]>0){
                    Smap[S.charAt(j)]++;
                    if(Smap[S.charAt(j)]<=Tmap[S.charAt(j)]){
                        found++;
                    }
                }
                j++;
            }
            // 找到了一个区间
            // 接下来动态维护这个
            while(found==T.length()){
                if(j-i<length){
                    length=j-i; res=S.substring(i,j);
                }
                if(Tmap[S.charAt(i)]>0){
                    Smap[S.charAt(i)]--;
                    if(Smap[S.charAt(i)]<Tmap[S.charAt(i)]){
                        found--;
                    }
                }
                i++;
            }
        }
        return res;
    }

}

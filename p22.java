package leetcode2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wy on 2017/6/13.
 */
public class p22 {
    public List<String> generateParenthesis(int n) {
           List<String> haha=new ArrayList<String>();
           if(n==1){
               haha.add("()");
               return haha;
           }
           List<String> all=generateParenthesis(n-1);
           for(int i=0;i<all.size();i++){
               haha.add("("+all.get(i)+")");
           }
           for(int i=1;i<n;i++){
               List<String> one=generateParenthesis(n-i);
               List<String> two=generateParenthesis(i);
               for(int j=0;j<one.size();j++){
                   for(int k=0;k<two.size();k++){
                       haha.add(one.get(j)+two.get(k));
                   }

               }

           }
           return haha;

    }

    public List<String> generateParenthesis1(int n) {
           back("",0,0,n);
           return result;
    }
    // ( or )
    List<String> result=new ArrayList<String>();
    public void back(String str,int left,int right,int n){
           if(left==n && right==n){
               result.add(str);
               return;
           }
           if(left<n){
               back(str+"(",left+1,right,n);
           }
           if(left>right){
               back(str+")",left,right+1,n);
           }
    }


}

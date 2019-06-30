package leetcode2;

/**
 * Created by wy on 2017/6/15.
 */
public class p5 {
    public String longestPalindrome(String s) {
           if(s.length()==0)
               return null;
           int n=s.length();
           int dp[][]=new int[n+1][n+1];
           for(int i=1;i<n+1;i++)
               dp[i][i]=1;
           String res=s.charAt(0)+"";
           for(int i=1;i<n;i++){
               for(int j=0;j<i;j++){
                 if(j!=i-1){
                 if(dp[j+1][i-1]>0&&s.charAt(j)==s.charAt(i)){
                     dp[j][i]=dp[j+1][i-1]+2;
                     if(i-j+1>res.length())
                         res=s.substring(j,i+1);
                 }
                 }else {
                     if(s.charAt(j)==s.charAt(i))
                         dp[j][i]=2;
                 }
               }

           }
           return res;
    }
    public boolean isPalindrome(int s,int e,String str){
           while (s<e){
                  if(str.charAt(s)==str.charAt(e))
                      return false;
           }
           return true;


    }



}

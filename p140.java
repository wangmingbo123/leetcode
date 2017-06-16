package leetcode2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wy on 2017/6/16.
 */
public class p140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        LinkedList<String>[] dp = (LinkedList<String>[]) new LinkedList<?>[s.length()+1];
        for(int i = s.length()-1; i >= 0; i--){
            if(wordDict.contains(s.substring(i,s.length()))) break;
            if(i == 0) return new LinkedList<String>();
        }

        for(int i = 0; i < dp.length; i++) dp[i] = new LinkedList<String>();

        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if((j == 0 || dp[j].size() > 0) && wordDict.contains(s.substring(j,i))) {
                    if(j == 0) dp[i].add(s.substring(j,i));
                    else {
                        for(String c : dp[j]) {
                            dp[i].add(c + " " + s.substring(j,i));
                        }
                    }
                }
            }
        }
        return dp[s.length()];
    }


    public ArrayList<String> wordBreak3(String s, List<String> dict){
        ArrayList<String> result = new ArrayList<String>();
        for(int j = s.length() - 1; j >= 0; j--){
            if(dict.contains(s.substring(j)))
                break;
            else{
                if(j == 0)
                    return result;
            }
        }
        int n=s.length()+1;
        ArrayList<String> dp[]=new ArrayList[n];
        for(int i=0;i<n;i++){
            //dp[i].add("");
            dp[i]=new ArrayList<String>();
            dp[0].add("");
        }
        for(int i=1;i<n;i++)
            for(int j=0;j<i;j++){
                String left=s.substring(j,i);
                boolean flag=dict.contains(left);
                if(flag){
                    if(j==0){
                        dp[i].add(left);
                    }else {
                        // dp[j] 是否有值
                        if(dp[j].size()!=0){
                            for(int k=0;k<dp[j].size();k++)
                                dp[i].add(dp[j].get(k)+" "+left);
                        }
                    }
                }
            }
        return dp[n-1];


    }


}

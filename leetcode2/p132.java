package leetcode2;

/**
 * Created by wy on 2017/6/16.
 */
public class p132 {
    public int minCut(String s) {
        int n=s.length();
        int hui[][]=new int[n][n];
        for(int i=0;i<n;i++)
            hui[i][i]=1;
        for(int i=1;i<n;i++)
            for(int j=0;j<i;j++){
                if(i-j==1){
                    if(s.charAt(j)==s.charAt(i))
                        hui[j][i]=1;
                }else {
                    if(s.charAt(j)==s.charAt(i)&&hui[j+1][i-1]==1)
                        hui[j][i]=1;
                }
            }
        int d[][]=new int[n][n];
        for(int i=0;i<n;i++)
            d[0][i]=i;
        for(int i=1;i<n;i++)
            for(int j=0;j<=i;j++){
                if(hui[j][i]==1){
                    if (j!=0){
                        d[0][i]=Math.min(d[0][i],d[0][j-1]+1);
                    }else{
                        d[0][i]=0;
                    }

                }
            }
        return d[0][n-1];
        //System.out.println(d[0][n-1]);
    }

}

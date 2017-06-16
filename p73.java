package leetcode2;

/**
 * Created by wy on 2017/6/16.
 */
public class p73 {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;


        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        for(int i=0;i<m;i++)
            if(matrix[i][0]==0){
                for(int j=0;j<n;j++)
                    matrix[i][j]=0;
            }

        for(int i=0;i<n;i++)
            if(matrix[0][i]==0){
                for(int j=0;j<m;j++)
                    matrix[j][i]=0;
            }
    }
}

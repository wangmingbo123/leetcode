package leetcode2;

/**
 * Created by wy on 2017/6/16.
 */
public class p121 {
    // 在扫描的过程中,记录最小值
    // [7,1,5,3,6,4]
    // arrogance 傲慢
    public int maxProfit(int[] prices) {
          if(prices.length<2)
               return 0;
          int res=0;
          int min=prices[0];
          for(int i=1;i<prices.length;i++){
              if(prices[i]>min){
                  res=Math.max(prices[i]-min,res);
              }else {
                  min=prices[i];
              }
          }
          return res;
    }
}

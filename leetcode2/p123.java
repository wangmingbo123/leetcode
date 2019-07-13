package leetcode2;


/**
 * Created by wy on 2017/6/16.
 */
public class p123 {
    public int maxProfit(int[] prices) {
        // these four variables represent your profit after executing corresponding transaction
        // in the beginning, your profit is 0.
        // when you buy a stock ,the profit will be deducted of the price of stock.
        int firstBuy = Integer.MIN_VALUE, firstSell = 0;
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;

        for (int curPrice : prices) {
            if (firstBuy < -curPrice) firstBuy = -curPrice; // the max profit after you buy first stock
            if (firstSell < firstBuy + curPrice) firstSell = firstBuy + curPrice; // the max profit after you sell it
            if (secondBuy < firstSell - curPrice) secondBuy = firstSell - curPrice; // the max profit after you buy the second stock
            if (secondSell < secondBuy + curPrice) secondSell = secondBuy + curPrice; // the max profit after you sell the second stock
        }

        return secondSell; // secondSell will be the max profit after passing the prices
    }
    public void test(){
           int a[]={2,1,2,0,1};
           my(a);
    }

    // [2,1,2,0,1]
    public int my(int[] prices){
           if(prices.length==0)
               return 0;
           int first[]=new int[prices.length];
           int second[]=new int[prices.length];
           int firstSmall=prices[0];
           for(int i=1;i<prices.length;i++){
               if(prices[i]>firstSmall){
                   first[i]=prices[i]-firstSmall;
               }else {
//                   firstSmall=Math.min(firstSmall,first[i]);
                     firstSmall=prices[i];
               }
               // [0,i] 0->i的最大
               first[i]=Math.max(first[i],first[i-1]);
           }
           //  first=[0,0,1,1,1]
        // [2,1,2,0,1]
           // o(n2) time limit
           for(int i=1;i<prices.length;i++){
               for(int j=0;j<i;j++){
                   int sen=Math.max(0,prices[i]-prices[j+1]);
                   second[i]=Math.max(second[i],first[j]+sen);
               }
               second[i]=Math.max(second[i-1],second[i]);
               // [0,j] [j+1,i]
               // 最后[j+1 i]为null
               // 仅剩下[0 i] 与first[i]等价
               second[i]=Math.max(first[i],second[i]);
           }
           return second[prices.length-1];
    }






}

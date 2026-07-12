
class Solution {

    static int maxProfit(int[] prices) {
        int minSoFar = prices[0];
        int res = 0;

        
        for (int i = 1; i < prices.length; i++) {
            
            // Update the minimum value seen so far 
            minSoFar = Math.min(minSoFar, prices[i]);
           
            // Update result if we get more profit                
            res = Math.max(res, prices[i] - minSoFar);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices = {7, 10, 1, 3, 6, 9, 2};
        System.out.println(maxProfit(prices));
    }
}
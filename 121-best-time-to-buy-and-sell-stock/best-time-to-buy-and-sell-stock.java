class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 1){
            return 0;
        }
        int left = 0;
        int right = 1;
        int max = 0;
        while(right<prices.length){
            if(prices[left] < prices[right]){
                int profit = prices[right] - prices[left];
                max = profit > max ? profit : max;
            }else {
                left = right;
            }
            right++;
        }
        return max;
    }
}
class Solution {
    public int maxProfit(int[] prices) {
        int answer = 0;
        int price = prices[0];

        for (int i = 1; i < prices.length; i++) {
            answer = Math.max(answer, prices[i] - price);
            if (prices[i] < price) {
                price = prices[i];
            }
        }

        return answer;
    }
}
class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        dp = [0 for i in range(2*k)]
        
        for i in range(k):
            dp[2*i] = -prices[0]
        
        for i in range(len(prices)):
            for j in range(k):
                dp[2*j] = max(dp[2*j], -prices[i]) if j == 0 else max(dp[2*j], dp[2*j - 1] - prices[i])
                dp[2*j+1] = max(dp[2*j+1], dp[2*j]+prices[i])
        
        
        return dp[2*k-1]
    
    
'''
做了123，这就很简单
123题，k=2，需要2*2=4个状态，即：第一次持有，第一次不持有，第二次持有，第二次不持有
188题，k=n，则需要2*n个状态，分别是：第一次持有，第一次不持有，第..., 第n次持有，第n次不持有
状态的转移和123题是类似的
看到这道题就想123就对了
'''
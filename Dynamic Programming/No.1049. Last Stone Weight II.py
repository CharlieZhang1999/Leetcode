class Solution:
    def lastStoneWeightII(self, stones: List[int]) -> int:
        s = sum(stones)
        target = s // 2
        dp = [False for i in range(target+1)]
        dp[0] = True
        
        for i in range(len(stones)):
            for j in range(len(dp)-1, -1, -1):
                if j-stones[i] >= 0:
                    dp[j] = dp[j] | dp[j-stones[i]]
                    
        
        for j in range(len(dp)-1, -1, -1):
            if dp[j]:
                return (s-j)-j
            
'''
刷了1049
看着复杂 其实只是变态的416
找到两堆加起来接近equal的sum 然后相减就是答案
做法都是同样的先求和s
然后target = s / 2
然后dp就是形为dp[n][target+1]的array
或者优化之后就是一维的dp[target+1]array
比如如果和是25，有一边能加起来是12的话
答案就是(25-12)-12 = 1!
'''
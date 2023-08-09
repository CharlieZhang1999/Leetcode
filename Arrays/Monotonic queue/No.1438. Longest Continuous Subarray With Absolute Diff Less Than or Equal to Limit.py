class Solution:
    def longestSubarray(self, nums: List[int], limit: int) -> int:
        minqueue = deque()
        maxqueue = deque()
        l = r = ans = 0
        for i in range(len(nums)):
            r = i
            while maxqueue and nums[maxqueue[-1]] < nums[i]:
                maxqueue.pop()
                
            while minqueue and nums[minqueue[-1]] > nums[i]:
                minqueue.pop()
                
            maxqueue.append(i)
            minqueue.append(i)
            
            while nums[maxqueue[0]] - nums[minqueue[0]] > limit:
                l += 1
                while l > maxqueue[0]:
                    maxqueue.popleft()
                    
                while l > minqueue[0]:
                    minqueue.popleft()
                    
                     
            ans = max(ans, r-l+1)
            
                
        return ans
    
    
'''
维持一个以index为底的minqueue 和 maxqueue的意义和优点是什么？
1、这样的话每次看一个window是不是eligible只要对比maxqueue[0] - minqueue[0] > limit 就行
2、如果大于limit，就把左边界increment（l+=1）然后相应的踢出maxqueue或minqueue里的元素，直到window里的maxqueue[0] - minqueue[0] <= limit
'''
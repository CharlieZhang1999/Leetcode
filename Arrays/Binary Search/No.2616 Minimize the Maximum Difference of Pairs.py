class Solution:
    def minimizeMax(self, nums: List[int], p: int) -> int:
        '''既然爱，难分是非；就别逃避，勇敢面对'''
        def canReach(mid):
            count = 0
            i = 0
            while i<len(nums)-1 and count<p:
                if nums[i+1] - nums[i] <= mid:
                    count += 1
                    i += 2
                else:
                    i += 1
                
            return count >= p
        
        nums.sort()
        left = 0
        right = nums[-1]
        
        while left < right:
            mid = left + (right - left) // 2
            if canReach(mid):
                right = mid
            else:
                left = mid + 1
                
        return left
    
'''
思路：
非典型binary search
对于一个diff，要不然符合它的pair >= p; 要不然符合它的pair < p。只有这两种情况
'''
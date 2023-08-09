class Solution:
    def minJumps(self, arr: List[int]) -> int:
        new_dict = {}
        n  = len(arr)
        
        for i in range(len(arr)):
            if arr[i] not in new_dict:
                new_dict[arr[i]] = [i]
            
            else:
                new_dict[arr[i]].append(i)
                
        queue = [0]
        # idx, step
        visited = {0}
        cur = queue
        step = 0
        while queue:
            nextqueue = []
           
            # headIdx = head[0]
            # headStep = head[1]
            for headIdx in queue:
                if headIdx == n-1:
                    return step

                idxArr = new_dict[arr[headIdx]]
                for i in range(len(idxArr)):
                    if idxArr[i] not in visited:
                        visited.add(idxArr[i])
                        nextqueue.append(idxArr[i])

                new_dict[arr[headIdx]].clear()

                if headIdx - 1 >= 0 and headIdx - 1 not in visited:
                    visited.add(headIdx-1)
                    nextqueue.append(headIdx-1)

                if headIdx + 1 < n and headIdx + 1 not in visited:
                    visited.add(headIdx+1)
                    nextqueue.append(headIdx+1)


            step += 1
            queue  = nextqueue
            
        return -1
    
'''
思路：
思路其实很简单，就是从idx=0 开始bfs。加入queue的分别为：i+1th idx,  i-1th idx,  j where arr[i] == arr[j]
但之前当我用visited = [] 然后check 是否一个idx in visited 时的normal bfs会有个TLE
而当我把visited = {}改用一个dictionary之后，normal bfs彻底成功
因为在check 一个元素in set 比 一个元素in list速度要快得多
https://stackoverflow.com/questions/2831212/python-sets-vs-lists

'''
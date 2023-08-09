class Solution(object):
    def __init__(self):
        self.children = [[]]
        self.s = ""
        self.ans = 1
    def longestPath(self, parent, s):
        """
        :type parent: List[int]
        :type s: str
        :rtype: int
        """
        self.children = [[] for i in range(len(parent))]
        self.s = s
        for i in range(1, len(parent)):
            self.children[parent[i]].append(i)
            
        self.dfs(0)
        return self.ans
        
    def dfs(self, cur):
   
        if(len(self.children[cur]) == 0):
            return 1
        

        dist = []
        for i in range(len(self.children[cur])):
            child = self.children[cur][i]
            if self.s[cur] == self.s[child]:
                dist.append(0)
                self.dfs(child)
            else:
                dist.append(self.dfs(child))
        
        dist = sorted(dist, reverse=True)
        
        res = 1
        for i in range(min(len(dist), 2)):
            res += dist[i]
            
        self.ans = max(self.ans, res)
        
        return 1+dist[0]
        

    
'''
思路：
经典树形dp吧，跟124如出一辙，只不过children从两个children变成了可以有n个children
0、假设path这个变量装着我各个children出发的longest path。比如我有三个children，包括它们的最长单边path分别为1，2，3 则path=[3,2,1] 这里要sort一下
1、考虑最长的两个子path，max(ans, path[0]+path[1]+1)更新全局变量ans
2、return的时候只return包括自己这个node的最长的单个path，相当于return max(path) + 1
'''
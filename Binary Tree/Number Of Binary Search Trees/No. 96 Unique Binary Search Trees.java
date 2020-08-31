class Solution {
    public int numTrees(int n) {
        int G [] = new int[n+1];
        G[0] = 1;
        G[1] = 1;
        for(int i = 2; i < G.length; i++){
            for(int j = 1; j <= i; j++){
                //j as the root
                G[i] += G[j-1] * G[i-j];//there are j-1 nodes on the left of the root and i-j nodes on the right of the root. So there are G[j-1] * G[i-j] times when j is the root
            }
        }
        return G[n];
        
    }
}
/*
难点：这道题对于我而言，很难往dynamic programming上想，因为我一直没找到他们之间的关系。
还是对bst不够熟悉把，其实property 2没想到就说明对bst不够熟悉。。
epiphany：
1、G(n)是所有数为root的情况之和，这是加法关系。
G(n) = F(1, n) + F(2, n) + ... + F(n, n). 

2、就在于当一个数为root时，它的左边有必然是那j-1个数所以是G(j-1)种排列，它的右边必然是那i-j个数所以是G(i-j)种排列，这是乘法关系。
F(i, n) = G(i-1) * G(n-i)	1 <= i <= n 
*/
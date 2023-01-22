class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        
        for(int i = 0; i < n; i++){
            int size = res.size();
            for(int k = size-1; k >= 0; k--){
                res.add(res.get(k) | 1 << i);
            }
        }
        return res;
    }
}
/*
思路：
n = 2时, [00, 01, 11, 10]
n = 3时, 原有的四个保持不动变成[000, 001, 011, 010] 后面加的四个是从k（size-1）开始对每个数的第一位加个1，这个操作通过res.get(k) | 1 << i来完成
10 -> 110
11 -> 111
01 -> 101
00 -> 100
（这个or 的operation和shift的结合是精髓）=> [000, 001, 011, 010, 110, 111, 101, 100]
*/ 
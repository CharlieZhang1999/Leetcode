class Solution {
    public int longestSubstring(String s, int k) {
        return helper(s.toCharArray(), 0, s.length(), k);
    }
    
    
    public int helper(char [] s, int left, int right, int k){
        if(right - left < k) return 0;
        int [] count = new int[26];
        
        for(int i = left; i < right; i++){
           count[s[i] - 'a']++;
        }
        
        for(int i = left; i < right; i++){
            if(count[s[i]-'a'] < k){
                int j = i+1;
                while(j < right && count[s[j] - 'a'] < k){
                    j++;
                }
                return Math.max(helper(s, left, i, k), helper(s, j, right, k));
            }
        }
        return right - left;   
    }
}
/*
tag: divide and conquer
思路：
1\先过一遍整个string的i-j index，用一个bucket来记录每个字母出现的次数
2\然后再从i-j遍历，遇到的第一个count[s[m]] < k的字母，那么说明答案这个substring要不然在其左，要不然在其右
3\于是自然而然就想到可以分成(i,m)和(m+1,j)这两个subproblem，但如果只是到此为止的话，runtime是55ms
4\因为有可能中间有不止一个invalid character, 比如aaacdebbbb, k = 3时，我们先遇到的invalid character是c，但其实d和e也invalid，所以我们可以用一个while，一次性把中间的几个consecutive invalid character都跳过，会节省很多时间。
*/
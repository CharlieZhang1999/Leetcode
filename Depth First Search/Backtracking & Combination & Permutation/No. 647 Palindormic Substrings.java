class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            count += extend(i, i, s);
            count += extend(i, i+1, s);
        }
        return count;
    }
    public int extend(int left, int right, String s){
        int count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            count++; left--; right++;
        }
        return count;
    }
}
/* So typical backtracking
Epiphany: 
    1\我的原solution是对于每个字母s[i]，去check它前面那个字母的palindrome parterner index，然后看能不能s[i] == s[palindrome parterner index-1]. 虽然也是O(n^2), 但是要建nested arraylist 废了很多空间时间
    2\这个backtracking solution和我之前的思路不一样的地方在于
      我之前的solution：只count以i为止（到i）的palindrome。要引入很多special case：把自己加上，如果和前面一样的话加上，如果和前面的parterner的前面一样的话加上。。。
      backtracking solution：count以i为中心展开的palindrome，没什么special case，（1）以自己为中心展开　       也就是extend(i, i) （2）以自己和相邻的元素一对为中心展开 extend(i. i+1);
      
     思想的差距啊...palindrome当然从中间展开比从边上展开要easy很多！
*/
class Solution {
    public String customSortString(String order, String s) {
        int [] bucket = new int[26];
        StringBuilder sb = new StringBuilder();
        
        for(char c:  s.toCharArray()){
            bucket[c-'a']++;
        }
        
        for(char o: order.toCharArray()){
            while(bucket[o-'a']-- > 0){
                sb.append(o);
            }
        }
        
        for(char i  = 'a'; i <= 'z'; i++){
            while(bucket[i-'a']-- > 0){
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
/*
#tag: bucket-sort
思路：
我一直以为是先bucket sort order这个string然后按index来sort s, 但如果这样的话首先要变成Character []才能进行Arrays.sort()其次还要把Character[] 变回String 太麻烦了。

这个做法的思路是，先bucket sort string s, 字母一样的就increment count。接着遍历order里面的所有character，遍历到的character c如果bucket[c-'a'] > 0 则append c。剩下的没遍历到的说明是不在order里但在s里的，所以需要第二个for loop再单独append一次。比如说order = "cba", s = "abcd"里的'd'就需要在第二个for loop里单独append。

*/
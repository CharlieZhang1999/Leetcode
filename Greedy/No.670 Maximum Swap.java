class Solution {
    public int maximumSwap(int num) {
        char [] charArr = String.valueOf(num).toCharArray();
        int [] bucket = new int[10];
        for(int i = 0; i < charArr.length; i++){
            bucket[charArr[i]-'0'] = i;
        }
        
        for(int i = 0; i < charArr.length; i++){
            for(int j = 9; j > charArr[i]-'0'; j--){
                if(bucket[j] > i){
                    charArr[bucket[j]] = charArr[i];
                    charArr[i] = (char)(j + '0');
                    return Integer.valueOf(new String(charArr));
                }
            }
        }
        
        
        return num;
    }
}
/*
思路：
记录每个数字最后出现的位置
然后从头(i=0)开始，如果(1)存在比这个nums[i]大的数字(2)且它的位置比i后,则交换并返回
https://www.youtube.com/watch?v=pDyh9VOMWgI


自己还是差太多了
bucket也不会
Integer -> String: 可以用String.valueOf(num)也可以用Integer.toString(num)
String -> Integer: 可以用Integer.valueOf(string)
希望我能掌握这几个技巧好吧！
*/
class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int n = s.length();
        int start = 0;
        for(int i = 0; i < rows; i++){
            start += cols;
            if(s.charAt(start % n) == ' '){
                start++;
            }
            else{
                while(start > 0 && s.charAt((start-1) % n) != ' '){
                    start--;
                }
            }
        }
        return start / n;
    }
}
/*
这道题是个锤子的dp
其实就是pointer+String罢了
潜规则是
1、不允许一个word串行
2、每一行的开头必须是一个word（的第一个字符），不能是空格
就看走到最后start是多少，那能装几个s就自动= start / s.length()

金玟庭天生帽女！我不跟没看过gtb的人讲话！
*/
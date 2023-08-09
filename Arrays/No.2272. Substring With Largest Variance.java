class Solution {
    public int largestVariance(String s) {
        int res = 0;
        int [] counter = new int[26];
        char [] wordArray = s.toCharArray();
        int [] arr = new int [s.length()];
        int minorTotal = 0;
        for(int i = 0; i < s.length(); i++){
            counter[s.charAt(i) - 'a']++;
        }
        
        // i is major, j is minor
        for(int i = 0; i < 26; i++){
            for(int j = 0; j < 26; j++){
                if(i == j || counter[i] == 0 || counter[j] == 0) {
                    continue;
                }
                Arrays.fill(arr, 0);
                minorTotal = 0;
                
                char major = (char) ('a' + i);
                char minor = (char) ('a' + j);
                for(int k = 0; k < wordArray.length; k++){
                    if(wordArray[k] == major){
                        arr[k] = 1;
                    }
                    
                    if(wordArray[k] == minor){
                        arr[k] = -1;
                        minorTotal++;
                    }
                    
                    
                }
                res = Math.max(res, kadaneAlgo(arr, minorTotal));
                
                
            }
        }
        return res;
        
    }
    
    public int kadaneAlgo(int [] arr, int minorTotal){
        int minorCount = 0;
        int localMax = 0, globalMax = 0;
        for(int num: arr){
            if(num < 0) {
                minorCount++;
                minorTotal--;
            }
            if(localMax + num < 0 && minorTotal > 0){
                localMax = 0;
                minorCount = 0;
            }
            else{
                localMax += num;
            }
            
            if(minorCount > 0){
                globalMax = Math.max(localMax, globalMax);
            }
            
        }
        
        return globalMax;
    }
}

/*
思路：
- 其实就是定一个major character和minor character。major character幻视为1，minor character幻视为-1，剩余都为0。然后用kadane algorighthm看最大的subarray sum。

- tweak 1: 这个subarray里面必须有一个minor character，比如‘aaa’不行的。但‘baaa’就可以。所以用一个variable minorCount。只有minorCount > 0的时候才可以更新globalSum
- tweak 2: 对于一种use case比如'lripaa'，如果不加特殊处理的话会return 0，因为就比如当a为major，l为minor时，第一个l因为localmax < 0直接被跳过了，localmax直接reset为0了。而之后因为没有l了所以globalSum都不会被更新，因此return 0。这是不对的。正确的答案应该是考虑第一个l并且和后面aa组成了-1+1+1=1 应该return 1。所以我们还要用一个变量叫minorRest或者minorTotal来track剩下的minor数量。如果这是最后一个minor了，那无论如何都不能跳过它应该保留它，必须要带着这个l，traverse剩下的字符才有意义。
*/
class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0;
        int n = s.length();
        char [] arr = s.toCharArray();
        int longest = 0, maxFrequency = 0;
        // HashMap<Character, Integer> map = new HashMap<>();
        int[] count = new int[26];
        for(; right < n; right++){
            // int curFrequency = map.getOrDefault(arr[right], 0)+1;
            maxFrequency = Math.max(++count[arr[right]-'A'], maxFrequency);
            // map.put(arr[right], curFrequency);
            
            while((right - left + 1) - maxFrequency > k){
                // map.put(arr[left], map.get(arr[left])-1);
                count[arr[left]-'A']--;
                left++;
            }
            
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }
}
/*
TAG: two pointer, sliding window, bucket sort

这道题跟1004题太异曲同工了！
孪生兄弟好吗！
而且是更general的case

思路：
我们只要看（某个字母的）maxfrequency有没有update就行。这个maxfrequency是指这个window内的frequency。

得到一个maxfrequency之后，我们相当于保证了一个maxfrequency+k size的window，然后拿这个window往后度（渡劫 bushi）如果这个window到了某一个路段某个字母的frequency > maxfrequency,那我们便对maxfrequency进行update，对answer也进行update，因为我们知道现在可以扩充当前的window使得window size = (updated)maxfrequency+k。

就比如AABACDEFEEE..,k=1来说
刚开始AABA是一个可行的window，maxFrequency = 3(3个A) 那这个window往后度，即使遇到BACD这种也不用decrement maxfrequency就继续往后度（毕竟我们已知可以保证一个size为3+k=4，k为1以下的window了），度到后面EFEEE的时候发现E的freq达到了4（新高）,更新maxFrequency = 4, 这时我们知道我们可以扩充当前的window size到4+k=5。所以继续拿size=5的window再往后度…
*/

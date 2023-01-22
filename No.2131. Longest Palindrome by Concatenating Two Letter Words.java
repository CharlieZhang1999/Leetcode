class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String w: words){
            map.put(w, map.getOrDefault(w, 0)+1);
        }
        boolean central = false;
        int res = 0;
        
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            if(entry.getValue() > 0){
                String w = entry.getKey();
                int count = entry.getValue();
                if(isPalindrome(w)){
                    if(count % 2 == 0){
                        res += count;
                    }
                    else{
                        if(!central){
                            central = true;
                            res += 1;
                        }
                        res += (count-1);
                    }
                }
                else if(w.charAt(0) < w.charAt(1)){
                    res += Math.min(count, map.getOrDefault(reverse(w), 0)) * 2;
                }
            }
        }
        return res*2;
    }
    public String reverse(String w){
        return ""+w.charAt(1)+w.charAt(0);
    }
    
    public boolean isPalindrome(String w){
        return w.charAt(0) == w.charAt(1);
    }
}

/*
tag: HashMap
思路：
1\如果是形似ww这样的，如果有偶数个那都可以加进来，如果有奇数个那就看看central有没有被占用，没有的话也可以全数加进来并且central=true
2\如果形似cb这样的，我们只看bc就行，因为在bc做判断的时候已经考虑并且加过cb的数量了。所以这就是为啥26行只考虑w.charAt(0) < w.charAt(1)的case，为的就是不重复数
*/
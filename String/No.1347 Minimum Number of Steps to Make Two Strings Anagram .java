class Solution {
    public int minSteps(String s, String t) {
        int res = 0;
        int[] arr = new int[26];
        int n = s.length();
        for(int i = 0; i < n; i++){
            arr[s.charAt(i)-'a']++;
            arr[t.charAt(i)-'a']--;
        }
        
        for(int i = 0; i < 26; i++){
            if(arr[i] > 0) res += arr[i];
        }
        return res;
    }
}

/*
第一次用了hashmap做，时间复杂度高一点
第二次用bucket做，只管正的不管负的，果然快一点
昨天刚看了金冬甜 kamp之旅要结束啦，会继续开心的对吧
*/
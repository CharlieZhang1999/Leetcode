class Solution {
    public List<Integer> partitionLabels(String s) {
        int [] last = new int[26];
        for(int i = 0; i < s.length();i++){
            last[s.charAt(i)-'a'] = i;
        }
        
        int j = 0, anchor = 0;
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            j = Math.max(j, last[s.charAt(i)-'a']);
            if(j == i){
                result.add(i-anchor+1);
                anchor = i+1;
            }
        }
        return result;
    }
}
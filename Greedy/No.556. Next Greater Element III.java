class Solution {
    public int nextGreaterElement(int n) {
        String s = String.valueOf(n);
        char [] array = s.toCharArray();
        
        int i = findI(array);
        Arrays.sort(array, i+1, array.length);
        long val = Long.parseLong(new String(array));
        if(val > n && val <= Integer.MAX_VALUE) return (int)val;
        return -1;
    }
    
    public int findI(char[] array){
        int i;
        int [] bucket = new int[10];
        for(i = array.length - 1; i >= 0; i--){
            int k = array[i]-'0';
            for(int j = k+1; j < 10; j++){
                if(bucket[j] > i){
                    array[i] = (char) ('0'+j);
                    array[bucket[j]] = (char) ('0'+k);
                    return i;
                }
            }
            bucket[k] = i;
        }
        return -1;
    }
}
/*
#tag: String, Greedy
思路：我用了No.670的思路，先maximum swap，之后再dscending sort i+1到尾部的部分

*/
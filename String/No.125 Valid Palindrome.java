class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        int l = s.length();

        while(left <= right){
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if(Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}
/*
记住，Character里有判断是否为alpha-numeric的方法，即Character.isLetterOrDigit()
这道题不一定要用String.replaceAll来做，又废O(N)空间，又废时间，属于是五废卡 = v =
*/
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int num1 = -1, count1 = 0, num2 = -1, count2 = 0;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == num1){
                count1++;
            }
            else if(nums[i] == num2){
                count2++;
            }
            else if(count1 == 0){
                num1 = nums[i];
                count1++;
            }
            else if(count2 == 0){
                num2 = nums[i];
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == num1){
                count1++;
            }
            
            else if(nums[i] == num2){
                count2++;
            }
        }
        
        if(count1 > n / 3){
            res.add(num1);
        }
        if(count2 > n/3){
            res.add(num2);
        }
        
        return res;
    }
}

/*
思路：
找到大于n/3的数，首先这种数不会超过两个。所以我们就定两个candidate
其次，这两个数肯定有信心不会被剩下的数抵消。就比如一共47个数，某两个数出现了16次，而剩下15个都是其他数，那无论如何怎样count1--, count2--，最后都不会抵消掉他们。
Boyer-moore algorithm
*/
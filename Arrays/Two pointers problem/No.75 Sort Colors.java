class Solution {
    public void sortColors(int[] nums) {
        int zero = 0, two = nums.length - 1;
        for(int i = 0; i < nums.length; i++){
            while(nums[i] == 2 && i < two){
                nums[i] = nums[two];
                nums[two] = 2;
                two--;
            }
            while(nums[i] == 0 && i > zero){
                nums[i] = nums[zero];
                nums[zero] = 0;
                zero++;
            }
        }
    }
}
/*
			§ No. 75 sort colors
				□ Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
				Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
				Note: You are not suppose to use the library's sort function for this problem.
				□ most voted solution
					• 设置两个pointer，左pointer保证这个pointer以左全是0.右pointer保证这个pointer以右全是2。然后两个pointer向中靠拢
					• 遍历：对于每一个数
						◊ 1\如果是2，那么和右pointer交换，交换后右pointer往左移一格（向中靠拢）
						◊ 2\如果是0，那么和左pointer交换，交换后左pointer往右移一格（向中靠拢）
                          3\如果是1，continue*/

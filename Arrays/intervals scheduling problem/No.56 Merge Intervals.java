class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) return intervals;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int []> result = new ArrayList<>();
        int [] new_interval = intervals[0];
        result.add(new_interval);
        for(int[] interval: intervals){
            if(new_interval[1] >= interval[0]){
                new_interval[1] = Math.max(new_interval[1], interval[1]);
            }
            else{
                new_interval = interval;
                result.add(new_interval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
/*
epiphany和难点：我知道是看一个interval的end是否比下一个interval的start大，如果大说明overlap就可以merge 但我不会sort；所以这道题的难点在于怎么根据2d array的每第一个element sort
					• 先按照每个interval的start sort好intervals（
						◊ 这个时候不得不提到Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])的骚操作了
						可以理解为Arrays.sort接受需要sort的object和sort的方法，比如如何compare两个元素呢 当然是by compare 他们的第一个元素啦
						告诉Array.sort 如果a[0] > b[0] return 1, a[0] <  b[0] return -1
						
					• 创建result为一个ArrayList
接着for loop 遍历每个interval，需要merge就merge， merge完没法merge了就可以add到result里，接着merge下一个interval*/
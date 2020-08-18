class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length <= 1) return 0;
        List<int []>result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int [] waited_interval = intervals[0];
        result.add(waited_interval);
        for(int [] interval: intervals){
            if(waited_interval[1] > interval[0] && waited_interval[1] <= interval[1]){
                continue;
            }
            
            if(waited_interval[1] > interval[0] && waited_interval[1] > interval[1]){
                result.remove(result.size()-1);
            }
            result.add(interval);
            waited_interval = interval;
        }
        return intervals.length - result.size();
    } 
}
/*public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0)  return 0;

        Arrays.sort(intervals, new myComparator());
        int end = intervals[0].end;
        int count = 1;        

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= end) {
                end = intervals[i].end;
                count++;
            }
        }
        return intervals.length - count;
    }
    
    class myComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.end - b.end;
        }
    }
}
难点在于如果几个intervals重复了，该取哪一个是最优化最greedy的
• epiphany：
◊ 两个做法
我的做法是按照interval.start来sort。如果两个interval重叠了，取interval.end比较小的那一个。eg 这样的话[1,2]和[1,3]永远取[1,2]； [1,3]和[2,4] 永远取[1,3]
另一种做法我也贴了，按照interval.end来sort，这样保证在前面的都是end保证最小的，优先选。for loop只要后续的interval和已有的不重叠，就无条件录取。这个做法的优点是只要做一次判断（是否重叠）就行了*/
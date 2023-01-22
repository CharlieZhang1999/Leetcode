class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<int[]> points = new ArrayList<>();
        for(int [] h: buildings){
            points.add(new int[]{h[0], -h[2]});
            points.add(new int[]{h[1], h[2]});
        }
        Collections.sort(points, new Comparator<int[]>(){
            @Override
            public int compare(int [] a, int [] b){
                return a[0] == b[0]?a[1]-b[1]:a[0]-b[0];
            }
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> (b-a));
        pq.offer(0);
        int prev = 0, cur = 0;
        for(int [] p: points){
            // case: start point
            if(p[1] < 0){
                pq.offer(-p[1]);
            }
            // case: end point
            else{
                pq.remove(p[1]);
            }
            
            cur = pq.peek();
            if(cur != prev){
                List<Integer> temp = new ArrayList<>();
                temp.add(p[0]);
                temp.add(cur);
                res.add(temp);
                prev = cur;
            } 
        }
        return res;
    }
}
/*
tag: skyline
link: https://leetcode.com/problems/the-skyline-problem/discuss/61192/Once-for-all-explanation-with-clean-Java-code(O(n2)time-O(n)-space)
终于做到skyline了
听说tt家有这题真的好难

思路：
1\要区分start point和end point，这里我们用sign区分。startpoint的高度是负数
2\为什么要这样区分呢，
case 0: sp 和 sp 相同：先读取高个子再读取矮个子，因为矮个子是不在天际线里的完全被高个子shadow住了，所以要先读取高个子的话，高个子的负数更小一点，会被先读取，good
case 1: ep 和 ep 相同：这时我们是先读取矮个子再读取高个子，因为这样先remove 矮个子的高度，再remove 高个子的高度，天际线确定没有矮个子的参与哈哈哈哈，good
case 2: sp 和 ep相同：一个建筑的ep是另一个建筑的sp时，先把后面sp的建筑读进来作为第二高度，再remove ep建筑的高度，这样的话天际线不会掉到0而是会掉到之前加进来的sp高度那里，good
3\h[1]为负数，是sp，所以加进pq，并且看看要不要更新cur和prev（也就是天际线的轮廓）
4\h[1]为正数，是ep，所以从pq remove，并且看看要不要更新cur和prev（也就是天际线的轮廓）

*/
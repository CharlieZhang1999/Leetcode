class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a,b) -> a[1]-b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int time = 0;
        for(int[] course: courses){
            pq.add(course[0]);
            time += course[0];
            if(time > course[1]){
                time-=pq.poll();
            }
        }
        return pq.size();
    }
}

/*
这题确实有hard的风范
这个optimal的rule看了答案半天甚至都没领会到
所以做greedy的题eg: find the maximum of xxx还是要看清楚本质

这道题的本质，在于按ddl排序，然后永远优先ddl晚而且duration短的选手（或者说永远remove ddl在前duration还长的课）
思路：
1\一个pq按ddl从小到大排序
2\for loop每次给pq加一节课，如果时间超了，就扔掉duration最长的那节课。为什么能保证这是可行解呢？我们来看个example
我们定义“可行”为这一个组合的课的duration加起来不超过他们的ddl
比如目前的状态下有课a1,b1,c1，他们是可行的；现在来了d1, 发现a1,b1,c1,d1不可行，那么只要剔除duration最长的课就是可行的了。因为 ：
(1)d1是duration最长的课，踢掉它变成a1,b1,c1  可行。
(2)a,b,c中有一节duration比d1长的课，比如c1是，那踢掉c1加上d1, 已知a1,b1,c1可行，又因为d1 duration比c1短而ddl又比c1晚，所以a1,b1,d1可行。
*/
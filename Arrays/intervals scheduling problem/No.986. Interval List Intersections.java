class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0, j = 0;
        int flen = firstList.length, slen = secondList.length;
        int[] waitinginterval;
        List<int[]> res = new ArrayList<>();
        
        while(i < flen && j < slen){
            int [] temp;
            if(firstList[i][0] > secondList[j][1]){
                j++;
                continue;
            }
            else if(secondList[j][0] > firstList[i][1]){
                i++;
                continue;
            }
            // overlap
            else{
                temp = new int[]{Math.max(firstList[i][0], secondList[j][0]), Math.min(firstList[i][1], secondList[j][1])};
                res.add(temp);
                if(firstList[i][1] > secondList[j][1]){
                    j++;
                }
                else{
                    i++;
                }
            } 
        }
        
        return res.toArray(new int[res.size()][]);
    }
    
}
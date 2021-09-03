class Solution {
    public List<List<Integer>> combine(int n, int k) {
        ArrayList<List<Integer>> ret = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(ret, temp, n, k, 1);
        return ret;
    }
    
    public void backtrack(List<List<Integer>> ans, List<Integer> temp, int n, int k, int start){
        if(temp.size() == k){
            ans.add(new ArrayList(temp));
            // temp = new ArrayList<>();
            return;
        }
        for(int i = start; i < n+1; i++){
            temp.add(i);
            backtrack(ans, temp, n, k, i+1);
            temp.remove(temp.size()-1);
        }
        
    }
}
/*

No. 77有感

有两个preserve order的方法：
一：subsequence， 一个backtrack里包含两个backtrack， no和yes
二：利用int start，保证1后面只能跟2、3、4， 2后面只能跟3、4 etc
*/
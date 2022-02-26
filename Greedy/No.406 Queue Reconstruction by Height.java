class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<>(){
            @Override
            public int compare(int[] a , int[] b){
                return a[0] != b[0]? b[0]-a[0]:a[1]-b[1];
            }
            
        });
        List<int[]> ans = new LinkedList<>();
        for(int [] person: people){
            ans.add(person[1], person);
        }
        
        return ans.toArray(new int[people.length][]);
    }
}

/*
打了第二针 好累
*/
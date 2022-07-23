class Solution {
    public boolean canReorderDoubled(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: arr){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        Arrays.sort(arr);
        for(int num: arr){
            int c = map.get(num);
            if(c <= 0) continue;
            if(map.containsKey(num*2)){
                int c1 = map.get(num*2);
                if(c1 > 0){
                    map.put(num*2,--c1);
                    map.put(num, --c);
                    continue;
                }
            }
            
            if(num % 2 == 0 && map.containsKey(num/2)){
                int c2 = map.get(num/2);
                if(c2 > 0){
                    map.put(num/2,--c2);
                    map.put(num, --c);
                    continue;
                }
            }
            return false;
            
        }
        
        return true;
    }
}
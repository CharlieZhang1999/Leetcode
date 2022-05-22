import java.util.Random;
class RandomizedSet {
    public Random random;
    public HashMap<Integer, Integer> map;
    public ArrayList<Integer> arrayList;
    public RandomizedSet() {
        random = new Random();
        arrayList = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val, arrayList.size());
        arrayList.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int loc = map.get(val);
        int s = arrayList.size();
        if(loc < s - 1){
            // if not the last one in the array, swap with the last one and update
            arrayList.set(loc, arrayList.get(s-1));
            map.put(arrayList.get(s-1), loc);
            
        }
        arrayList.remove(s-1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        int idx = random.nextInt(arrayList.size());
        return arrayList.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */


 /*
 主要是
 getrandom的话通过Arraylist比较容易实现random
 remove的话通过Hashmap找index很快, O(1)
 所以这道题就用的ArrayList + HashMap
 */
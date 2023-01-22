class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, List<String>> preq = new HashMap<>();
        List<String> res = new ArrayList<>();
        for(int i = 0; i < recipes.length; i++){
            map.put(recipes[i], ingredients.get(i).size());
            for(String s: ingredients.get(i)){
                preq.putIfAbsent(s, new ArrayList<String>());
                preq.get(s).add(recipes[i]);
            }
        }


        Queue<String> queue = new LinkedList<>();
        for(String sup: supplies){
            queue.offer(sup);
        }

        while(!queue.isEmpty()){
            String cur = queue.poll();
            if(preq.containsKey(cur)){
                for(String recipe: preq.get(cur)){
                    int rest = map.get(recipe)-1;
                    if(rest == 0){
                        res.add(recipe);
                        queue.offer(recipe);
                    }
                    map.put(recipe, rest);
                }
            }
        }
        return res;
    }
}

// 经典topological sort
// 反正就是如果prerequisite == 0，就push到queue里
import java.util.*;

/*
topological sort
*/
class Solution23 {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Set<String>> map = new HashMap<>(); // key: ingredients; value: 可以构成的recipes
        Map<String, Integer> inDegree = new HashMap<>(); // key: recipe, value: how many needed
        
        for (int i = 0; i < recipes.length; i++) {
            for (String ing : ingredients.get(i)) {
                if (!map.containsKey(ing)) {
                    map.put(ing, new HashSet<>());
                } 
                map.get(ing).add(recipes[i]);
            }
            inDegree.put(recipes[i], ingredients.get(i).size());
        }
        
        List<String> res = new ArrayList<>();
        Queue<String> queue = new ArrayDeque<>();
        for (String supply : supplies) {
            queue.offer(supply);
        }
        
        while (!queue.isEmpty()) {
            String ing = queue.poll();
            if (map.containsKey(ing)) {
                for (String recipe : map.get(ing)) {
                    int in = inDegree.get(recipe);
                    in--;
                    if (in == 0) {
                        queue.offer(recipe);
                        res.add(recipe);
                    }
                    inDegree.put(recipe, in);
                }
            }
        }
        return res;
    }
}
/*

2115. Find All Possible Recipes from Given Supplies
Medium


You have information about n different recipes. You are given a string array recipes and a 2D string array ingredients. The ith recipe has the name recipes[i], and you can create it if you have all the needed ingredients from ingredients[i]. Ingredients to a recipe may need to be created from other recipes, i.e., ingredients[i] may contain a string that is in recipes.

You are also given a string array supplies containing all the ingredients that you initially have, and you have an infinite supply of all of them.

Return a list of all the recipes that you can create. You may return the answer in any order.

Note that two recipes may contain each other in their ingredients.

 

Example 1:

Input: recipes = ["bread"], ingredients = [["yeast","flour"]], supplies = ["yeast","flour","corn"]
Output: ["bread"]
Explanation:
We can create "bread" since we have the ingredients "yeast" and "flour".
Example 2:

Input: recipes = ["bread","sandwich"], ingredients = [["yeast","flour"],["bread","meat"]], supplies = ["yeast","flour","meat"]
Output: ["bread","sandwich"]
Explanation:
We can create "bread" since we have the ingredients "yeast" and "flour".
We can create "sandwich" since we have the ingredient "meat" and can create the ingredient "bread".
Example 3:

Input: recipes = ["bread","sandwich","burger"], ingredients = [["yeast","flour"],["bread","meat"],["sandwich","meat","bread"]], supplies = ["yeast","flour","meat"]
Output: ["bread","sandwich","burger"]
Explanation:
We can create "bread" since we have the ingredients "yeast" and "flour".
We can create "sandwich" since we have the ingredient "meat" and can create the ingredient "bread".
We can create "burger" since we have the ingredient "meat" and can create the ingredients "bread" and "sandwich".
 

Constraints:

n == recipes.length == ingredients.length
1 <= n <= 100
1 <= ingredients[i].length, supplies.length <= 100
1 <= recipes[i].length, ingredients[i][j].length, supplies[k].length <= 10
recipes[i], ingredients[i][j], and supplies[k] consist only of lowercase English letters.
All the values of recipes and supplies combined are unique.
Each ingredients[i] does not contain any duplicate values.


*/


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class main2115 {
    public static void main(String[] args) {
        Solution2115 sol = new Solution2115();
        String[] recipes, supplies;
        String[][] ing;
        List<List<String>> ingredients;
        List<String> res;

        recipes = new String[]{"bread"};
        ing = new String[][]{{"yeast","flour"}};
        ingredients = sol.convArr2List(ing);
        supplies = new String[]{"yeast","flour","corn"};
        res = sol.findAllRecipes(recipes, ingredients, supplies);
        System.out.println(Arrays.toString(res.toArray()));
        
        recipes = new String[]{"bread","sandwich"};
        ing = new String[][]{{"yeast","flour"},{"bread","meat"}};
        ingredients = sol.convArr2List(ing);
        supplies = new String[]{"yeast","flour","meat"};
        res = sol.findAllRecipes(recipes, ingredients, supplies);
        System.out.println(Arrays.toString(res.toArray()));
        
        recipes = new String[]{"bread","sandwich","burger"};
        ing = new String[][]{{"yeast","flour"},{"bread","meat"},{"sandwich","meat","bread"}};
        ingredients = sol.convArr2List(ing);
        supplies = new String[]{"yeast","flour","meat"};
        res = sol.findAllRecipes(recipes, ingredients, supplies);
        System.out.println(Arrays.toString(res.toArray()));
    }

}



/*
Method: topological sort
tc: o(v+e)
sc: O(e)

1. graph: map- k: ingredients, v: list<recipies>
          indegree: map- k: recipie, v: ingredients to be found
2. add recipies with v == 0 to result
*/
class Solution2115 {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        // Construct directed graph and count in-degrees.
        Map<String, Set<String>> ingredientToRecipes = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < recipes.length; ++i) {
            for (String ing : ingredients.get(i)) {
                ingredientToRecipes.computeIfAbsent(ing, s -> new HashSet<>()).add(recipes[i]);
            }
            inDegree.put(recipes[i], ingredients.get(i).size());
        }
        // Toplogical Sort.
        List<String> ans = new ArrayList<>();
        Queue<String> available = Stream.of(supplies).collect(Collectors.toCollection(LinkedList::new));
        while (!available.isEmpty()) {
            String ing = available.poll();
            if (ingredientToRecipes.containsKey(ing)) {
                for (String rcp : ingredientToRecipes.remove(ing)) {
                    if (inDegree.merge(rcp, -1, Integer::sum) == 0) {
                        available.offer(rcp);
                        ans.add(rcp);
                    }
                }
            }
        }
        return ans;
    }
    
    public List<List<String>> convArr2List(String[][] strs) {
        List<List<String>> res = new ArrayList<>();
        for (String[] str : strs) {
            res.add(Arrays.asList(str));
        }
        return res;
    }
}
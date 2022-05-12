public class main0294 {
    public static void main(String[] args) {
        
    }
}


class Solution { // 23 - 28
    public boolean canWin(String currentState) {
        if (currentState == null || currentState.length() < 2) return false;
        Set<String> winSet = new HashSet<>();
        return dfs(currentState, winSet);
    }
    private boolean dfs(String currentState, Set<String> winSet) {
        if (winSet.contains(currentState)) return true;
        for (int i = 0; i < currentState.length()-1; i++) {
            if (currentState.charAt(i) == '+' && currentState.charAt(i+1) == '+') {
                String op = currentState.substring(0,i) + "--" + currentState.substring(i+2);
                if (!dfs(op, winSet)) {
                    winSet.add(currentState);
                    return true;
                }
            }
        }
        return false;
    }
}
import java.util.*;

public class main0950 {
    public static void main(String[] args) {
        Solution0950 sol = new Solution0950();
        int deck[], res[];

        deck = new int[]{17,13,11,2,3,5,7};
        res = sol.deckRevealedIncreasing(deck);
        System.out.println(Arrays.toString(res));
    }
}


class Solution0950 {
    public int[] deckRevealedIncreasing(int[] deck) {
        int N = deck.length;
        Deque<Integer> index = new LinkedList();
        for (int i = 0; i < N; ++i)
            index.offerLast(i);

        int[] ans = new int[N];
        Arrays.sort(deck);
        for (int card: deck) {
            //System.out.printf("%d,", index.peekFirst());
            ////System.out.println(Arrays.toString(index.toArray()));
            ans[index.pollFirst()] = card;
            if (!index.isEmpty())
                
                index.offerLast(index.pollFirst());
        }

        return ans;
    }
}
/*
[0, 1, 2, 3, 4, 5, 6]
[2, 3, 4, 5, 6, 1]
[4, 5, 6, 1, 3]
[6, 1, 3, 5]
[3, 5, 1]
[1, 5]
[5]

这个是它DEQUE里的顺序 比我之前想得复杂 结尾会有交叉
有点先射箭 后画靶的意思 先模拟输出操作顺序（数列的序号） 然后把排好的增序负在对应位置

*/
public class main1423 {
    
}
class Solution1423 {
    //tc/sc: O(k)
    public int maxScore0(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int[] front = new int[k+1];        
        int[] rear = new int[k+1];
        
        for (int i = 0; i < k; i++) {
            front[i+1] = front[i] + cardPoints[i];       
            rear[i+1] = rear[i] + cardPoints[len-1-i];
        }
        int maxscore = 0;
        for (int i = 0; i <= k; i++) {
            maxscore = Math.max(maxscore, front[i] + rear[k-i]);
        }
        return maxscore;
    }
    // sc: optimize to o(k)
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int frontscore = 0, rearscore = 0;
        for (int i = 0; i < k; i++) {
            frontscore += cardPoints[i];
        }
        int maxscore = frontscore;
        int curscore = 0;
        for (int j = 1; j <= k; j++) { // j - length of right window
            frontscore -= cardPoints[k-j];
            rearscore += cardPoints[len - j];
            curscore = frontscore + rearscore;
            maxscore = Math.max(maxscore, curscore);
        }
        return maxscore;
    }
}
public class Solution 
{
    public int ConnectSticks(int[] sticks) 
    {
        int n = sticks.Length;
        if(n < 2)
        {
            return 0;
        }
        SortedSet<(int,int)> pq = new SortedSet<(int,int)>();
        
        for(int i = 0; i < n ; i ++)
        {
            pq.Add((sticks[i], i));
        }
        int loop = n;
        int ans = 0;
        while(pq.Count > 1)
        {
            (int min1, int count) = pq.Min;
            pq.Remove((min1, count));
            (int min2, int count2) = pq.Min;
            pq.Remove((min2, count2));
            int next = min1 + min2;
            ans += next;   
            pq.Add((next, loop));
            loop ++;
        }

        return ans;
    }
}
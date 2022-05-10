class Solution2110 {
public:
    long long getDescentPeriods(vector<int>& prices) {
        long temp = 1; // longest desc
        long long count = 1;
        //long prev = prices[0];
        for (int i = 1; i < prices.size(); i++) {
            if (prices[i] == prices[i-1] - 1) {
                temp++;
            } else { 
                temp = 1;
            }
            count += temp;
            //System.out.print(count + " ");
        }
        return count;        
    }
};

int main(){

    return -1;
}
public class main1352 {
    
}

class ProductOfNumbers { // 15-21
    List<Integer> preProd;
    public ProductOfNumbers() {
        preProd = new ArrayList<>();
        preProd.add(1);    
    }
    
    public void add(int num) {
        if (num == 0) {
            preProd = new ArrayList<>();
            preProd.add(1);  
        } else {
            int n = preProd.size();
            preProd.add(preProd.get(n-1)*num);
        }
    }
    
    public int getProduct(int k) {
         int n = preProd.size();
        return k < n ? preProd.get(n-1)/preProd.get(n-1-k) : 0;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
import java.util.*;

public class main1352 {
    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);        // [3]
        productOfNumbers.add(0);        // [3,0]
        productOfNumbers.add(2);        // [3,0,2]
        productOfNumbers.add(5);        // [3,0,2,5]
        productOfNumbers.add(4);        // [3,0,2,5,4]
        System.out.println(productOfNumbers.getProduct(2)); // return 20. The product of the last 2 numbers is 5 * 4 = 20
        System.out.println(productOfNumbers.getProduct(3)); // return 40. The product of the last 3 numbers is 2 * 5 * 4 = 40
        System.out.println(productOfNumbers.getProduct(4)); // return 0. The product of the last 4 numbers is 0 * 2 * 5 * 4 = 0
        productOfNumbers.add(8);        // [3,0,2,5,4,8]
        System.out.println(productOfNumbers.getProduct(2)); // return 32. The product of the last 2 numbers is 4 * 8 = 32 
    }
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
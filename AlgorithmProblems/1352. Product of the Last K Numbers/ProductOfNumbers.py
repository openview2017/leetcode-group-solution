class ProductOfNumbers:

    def __init__(self):
        self.A = [1]

    def add(self, num: int) -> None:
        if num == 0:
            self.A = [1]
        else:
            self.A.append(self.A[-1]*num)

    def getProduct(self, k: int) -> int:
        if k >= len(self.A): return 0
        else: return self.A[-1] // self.A[-1-k]
        


# Your ProductOfNumbers object will be instantiated and called as such:
# obj = ProductOfNumbers()
# obj.add(num)
# param_2 = obj.getProduct(k)

productOfNumbers = ProductOfNumbers()
productOfNumbers.add(3)        # [3]
productOfNumbers.add(0)        # [3,0]
productOfNumbers.add(2)        # [3,0,2]
productOfNumbers.add(5)        # [3,0,2,5]
productOfNumbers.add(4)        # [3,0,2,5,4]
print(productOfNumbers.getProduct(2)) # return 20. The product of the last 2 numbers is 5 * 4 = 20
print(productOfNumbers.getProduct(3)) # return 40. The product of the last 3 numbers is 2 * 5 * 4 = 40
print(productOfNumbers.getProduct(4)) # return 0. The product of the last 4 numbers is 0 * 2 * 5 * 4 = 0
productOfNumbers.add(8)        # [3,0,2,5,4,8]
print(productOfNumbers.getProduct(2)) # return 32. The product of the last 2 numbers is 4 * 8 = 32 
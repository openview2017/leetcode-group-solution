/*
给 A 和 B 两个长度都是 N 的数组，返回 fair index 的个数。每个数组从 index K 劈成两部分，四部分的和相等，K 就是 fair index。
sum(A[0]+A[1] + …… + A[K-1]),
sum(A[K] + A[K+1] + …… + A[N-1]),
sum(B[0]+B[1] + …… + B[K-1]),
sum(B[K] + B[K+1] + …… + B[N-1]) 这四个 sum 相等。
A = [A0, A1, A2, A3]
B = [B0, B1, B2, B3]
如果 A0 + A1 = A2 + A3 = B0 + B1 = B2 + B3，2 就是 fair index
Example：
A = [0, 4, -1, 0, 3]，B = [0, -2, 5, 0, 3]，有 3 和 4 两个 fair index，所以 return 2；
A = [2, -2, -3, 3]，B = [0, 0, 4, -4]，只有 2 一个 fair index，所以 return 1；
A = [4, -1, 0, 3]，B = [-2, 6, 0, 4]，没有 fair index，所以 return 0；
A = [3, 2, 6]，B = [4, 1, 6]， return 0；
A = [1, 4, 2, -2, 5]，B = [7, -2,‍‍‍‍‌‌‌‍‌‌‍‍‍‍‍‌‌‍ -2, 2, 5] 有 2 和 4 两个 fair index，return 2
*
* */

public class FairIndex {

}
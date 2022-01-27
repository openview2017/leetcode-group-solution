# Number Of Ways of pages  

**Reference:**   
(https://leetcode.com/discuss/interview-question/1488281/Amazon-OA)  

The Amazon Kindle Store is an online e-book store where readers can choose a book from a wide range of categories. It also provides the ability to bookmark pages the user wishes to return to later. A book is represented as a binary string having two types of pages:  
*'0'*: an ordinary page  
*'1'*: a bookmarked page  
Find the number of ways to select 3 pages in ascending index order such that no two adjacent selected pages are of the same type.  

**Example**  
book = '01001'  
The following sequences of pages match the criterion:  

    [1, 2 ,3], that is, 01001 → 010.  
    [1, 2 ,4], that is, 01001 → 010.  
    [2, 3 ,5], that is, 01001 → 101.  
    [2, 4 ,5], that is, 01001 → 101.  
The answer is 4.  

**Function Description**  
Complete the function *numberOfWays* in the editor below.  
*numberOfWays* has the following parameter:
*string book*: a string that represents the pages of the book  

**Returns**  
*long*: the total number of ways to select 3 pages that meet the criterion  

**Constraints**  
1 ≤ | book | ≤ 2 · 10^5  
Each character in book is either '0' or '1'.  
Sample Case 0  
Sample Input For Custom Testing  
STDIN FUNCTION  
10111 → book = "10111"  
Sample Output  
3  
Explanation    
The following sequences of pages match the criterion:    

    [1, 2 ,3], that is, 10111 → 101.  
    [1, 2 ,4], that is, 10111 → 101.  
    [1, 2 ,5], that is, 10111 → 101.  
Sample Case 1  
Sample Input For Custom Testing  
STDIN FUNCTION  
0001 → book = "0001"  
Sample Output  
0  

Explanation  
It is not possible to pick a sequence of 3 pages that sa‍‌‍‍‌‍‌‌‌‌‍‌‌‌‍‍‌‌‌‌tisfies the conditions.  

**The Inicial Code**
```
public class Result {
/* Complete the 'numberOfWays' function below
* The function is expected to return a LONG_INTEGER
* The function accepts STRING book as parameter
*/
public static long numberOfWays(String book) {
   
}
```
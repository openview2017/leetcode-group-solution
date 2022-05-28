# Menu tree nodes changed  

**Reference:**     
(https://leetcode.com/discuss/interview-question/1265810/Doordash-PhoneScreen)  


At DoorDash, menus are updated daily even hourly to keep them up-to-date. Each menu can be regarded as a tree. When the merchant   sends us the latest menu, can we calculate how many nodes has changed?  

Assume each Node structure is as below:  
~~~
class Node {
String key;
int value;
boolean active;
List children;
}
~~~
Assume there are no duplicate nodes with the same key.  

Output: Return the number of changed nodes in the tree.  

Example 1
Existing Menu in our system:  

Existing tree
~~~
            a(1, T)
            /       \
        b(2, T)   c(3, T)
    /       \           \
d(4, T)     e(5, T)     f(6, T)
~~~
( Legend - a(1, T) a is the key, 1 is the value, T is True for active status )  

New Menu sent by the Merchant:  

New tree  
~~~
            a(1, T)
            /       \
                   c(3, F)
                       \
                         f(66, T)
~~~

Expected Answer: 5 Explanation: Node b, Node d, Node e are automatically set to inactive. The active status of Node c and the value of Node f changed as well.

Example 2  
Existing Menu in our system:  

Existing tree  
~~~
            a(1, T)
            /       \
        b(2, T)   c(3, T)
    /       \           \
d(4, T)     e(5, T)     g(6, T)
~~~
New Menu sent by the Merchant:  

New tree
~~~
                a(1, T)
            /           \
        b(2, T)         c(3, T)
    /       \          /       \
d(4, T)     e(5, T)   f(6, T) g(7, F)
~~~
Expected Answer: 2 Explanation: Node f is a newly-added node. Node g changed from Active to inactive
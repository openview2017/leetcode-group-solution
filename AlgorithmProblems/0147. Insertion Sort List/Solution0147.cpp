#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
  ListNode* insertionSortList(ListNode* head) {
    ListNode dummy;
    
    while (head) {
      ListNode* iter = &dummy;
      while (iter->next && head->val > iter->next->val)
        iter = iter->next;
      ListNode* next = head->next;
      head->next = iter->next;
      iter->next = head;
      head = next;
    }
    
    return dummy.next;
  }
};
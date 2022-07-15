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

class Solution0148 {
public:
  ListNode* sortList(ListNode* head) {
    // 0 or 1 element, we are done.
    if (!head || !head->next) return head;
    ListNode* slow = head;
    ListNode* fast = head->next;    
    while (fast && fast->next) {
      fast = fast->next->next;
      slow = slow->next;
    }
    ListNode* mid = slow->next;    
    slow->next = nullptr; // Break the list.
    return merge(sortList(head), sortList(mid));
  }
private:
  ListNode* merge(ListNode* l1, ListNode* l2) {
    ListNode dummy(0);
    ListNode* tail = &dummy;
    while (l1 && l2) {
      if (l1->val > l2->val) swap(l1, l2);
      tail->next = l1;
      l1 = l1->next;
      tail = tail->next;
    }
    tail->next = l1 ? l1 : l2;    
    return dummy.next;
  }
};
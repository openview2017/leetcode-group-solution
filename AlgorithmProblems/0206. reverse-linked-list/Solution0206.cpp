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

class Solution0206 {
public:
    ListNode* reverseListIter(ListNode* head) {
        ListNode* prev = nullptr;        
        ListNode* curr = head;
        ListNode* nxt = nullptr;
        while (curr != nullptr) {
            nxt = curr->next;
            curr->next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }

public:
    ListNode* reverseListRec(ListNode* head)  {
        if (head == nullptr || head->next == nullptr) {
            return head;
        }
        ListNode* p = reverseList(head->next);
        head->next->next = head;
        head->next = nullptr;
        return p;
    }
};

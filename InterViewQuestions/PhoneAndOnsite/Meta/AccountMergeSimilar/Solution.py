import collections
class Node:
    def __init__(self):
        self.data = None
        self.rank = 1
        self.parent = None
        
class DisjointSet:
    def __init__(self):
        self.data2Node = {}
        
    def makeSet(self, data):
        if data in self.data2Node:
            return
        node = Node()
        node.data = data
        node.parent = node
        self.data2Node[data] = node
        
    def findSetNode(self, node):
        parent = node.parent
        if parent == node:
            return parent
        node.parent = self.findSetNode(node.parent)
        return node.parent
    
    def findSet(self, data):
        return self.findSetNode(self.data2Node[data]).data
    
    def union(self, data1, data2):
        for d in [data1, data2]:
            if d not in self.data2Node:
                self.makeSet(d)
        node1 = self.data2Node[data1]
        node2 = self.data2Node[data2]
        p1 = self.findSetNode(node1)
        p2 = self.findSetNode(node2)
        if p1 == p2:
            return
        if p1.rank <= p2.rank:
            if p1.rank == p2.rank:
                p2.rank += 1
            p1.parent = p2
        else:
            p2.parent = p1
            
class Solution:
    def accountsMerge2(self, accounts):
        djs = DisjointSet()
        email2People = collections.defaultdict(list)
        for p in accounts:
            djs.makeSet(p)
            for em in accounts[p]:
                email2People[em].append(p)
        for email in email2People:
            pList = email2People[email]
            for i in range(1, len(pList)):
                djs.union(pList[0], pList[i])
        parent2People = collections.defaultdict(list)
        for p in accounts:
            parent = djs.findSet(p)
            parent2People[parent].append(p)
        ans = []
        for parent in parent2People:
            ans.append(parent2People[parent])
        return ans
                
            
        
s = Solution()
accounts = {"people1":["email1", "email2"], "people2": ["email2", "email3"], "people3": ["email4"], 
            "people4":["email1"]}
s.accountsMerge2(accounts)

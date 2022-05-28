class Node:
    def __init__(self, key, value=0, active=False, children=[]):
        self.key = key
        self.value = value
        self.active = active
        self.children = []

class MenuNodes:
    def compareNodes(self, old_node, new_node):
        diff = 0
        if not old_node and not new_node:
            return 0
        if not old_node or not new_node or not self.equals(old_node, new_node):
            print("old: " + str(old_node.value) if old_node else "")
            print("new: " + str(new_node.value) if new_node else "")
            print("===")
            diff += 1

        old_hashset = self.buildMap(old_node)
        new_hashset = self.buildMap(new_node)

        for key, value in old_hashset.items():
            if key in new_hashset:
                diff += self.compareNodes(value, new_hashset[key])
            else:
                diff += self.compareNodes(value, None)
        for key, value in new_hashset.items():
            if key not in old_hashset:
                diff += self.compareNodes(value, None)
        return diff
    def equals(self, node1, node2):
        return node1.key == node2.key and node1.value == node2.value and node1.active == node2.active
    
    def buildMap(self, node):
        node_map = dict()
        if not node:
            return node_map
        for cur in node.children:
            node_map[cur.key] = cur
        return node_map


if __name__ == "__main__":
    # Test case1
    node1 = Node("a", 1, True)
    b = Node("b", 2, True)
    c = Node("c", 3, True)
    d = Node("d", 4, True)
    e = Node("e", 5, True)
    f = Node("f", 6, True)

    node1.children = [b, c]
    b.children = [d, e]
    c.children = [f]

    node2 = Node("a", 1, True)
    c = Node("c", 3, False)
    f = Node("f", 66, True)

    node2.children = [c]
    c.children = [f]

    menuNodes = MenuNodes()
    print(menuNodes.compareNodes(node1, node2))
    print("Expected result: {}".format(5))
        

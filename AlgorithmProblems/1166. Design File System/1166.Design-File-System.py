class TrieNode:
    def __init__(self, key="", value=-1):
        self.key = key
        self.value = value
        self.children = dict()
        
class FileSystem:
    """
    Space complexity: O(T) -> T components
    """
    def __init__(self):
        self.root = TrieNode()

    """
    Time complexity: O(T) -> T components
    """
    def createPath(self, path: str, value: int) -> bool:
        files = path.split("/")
        cur = self.root
        for i in range(1, len(files)):
            if files[i] not in cur.children:
                if i == len(files)-1:
                    cur.children[files[i]] = TrieNode(files[i], value)
                else:
                    return False
            else:
                if i == len(files)-1:
                    return False
            cur = cur.children[files[i]]
        return True
            
    """
    Time complexity: O(T) -> T components
    Space complexity: O(1)
    """
    def _get_node(self, path: str):
        files = path.split("/")
        cur = self.root
        for i in range(1, len(files)):
            if files[i] not in cur.children:
                return None
            cur = cur.children[files[i]]
        return cur

    def get(self, path: str) -> int:
        cur = self._get_node(path)
        if not cur:
            return -1
        return cur.value
    
    def set(self, path: str) -> int:
        cur = self._get_node(path)
        cur.value = value
        return
    
    def delete(self, path: str):
        parent_path = path[:path.rfind("/")]
        parent_node = self._get_node(parent_path)
        cur_name = path[path.rfind("/")+1:]
        if cur_name in parent_node.children:
            parent_node.children.pop(cur_name)
            return True
        else:
            return False
        


# Your FileSystem object will be instantiated and called as such:
# obj = FileSystem()
# param_1 = obj.createPath(path,value)
# param_2 = obj.get(path)
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
    def get(self, path: str) -> int:
        files = path.split("/")
        cur = self.root
        for i in range(1, len(files)):
            if files[i] not in cur.children:
                return -1
            cur = cur.children[files[i]]
        return cur.value
        


# Your FileSystem object will be instantiated and called as such:
# obj = FileSystem()
# param_1 = obj.createPath(path,value)
# param_2 = obj.get(path)
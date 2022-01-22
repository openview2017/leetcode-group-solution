class Node:
    def __init__(self):
        """
        Tree is data structure
        """
        
        self.findWord = True                    
        self.chd = [None] * 26                  # 开辟26字母空间

class Trie:
    def __init__(self):
        """
        initialize tree data structure
        """
        self._node = Node()
      #  self._tree = {}
    
    def _get_index(self, char):
        """
        :param char: char type
        :return: int
        
        convert char to int
        """
        return ord(char) - ord('a')
    
    def _is_find(self, word):
        """
        :param word: string
        :return: Node
        
        search a string exist in Trie
        
        """
        node = self._node             
        
        for char in word:
            index = self._get_index(char)     
            
            if node.chd[index] == None:              
                return None                               
            node = node.chd[index]
        return node
    
    def insert(self, word: str) -> None:
        """
        :param word: string
        
        insert a string to Trie
        """
        node = self._node
        
        for char in word:
            index = self._get_index(char)              
            
            if node.chd[index] == None:
                node.chd[index] = Node()                     
                node.chd[index].findWord = False
            node = node.chd[index]
        node.findWord = True                       # word inserted, set findWord to True
     
    
    def search(self, word: str) -> bool:

        """
        :param: word: string
        :return: bool
        
        search a word exist in Trie 
        """
        node = self._is_find(word)        
        return node != None and node.findWord   
    
    def startsWith(self, prefix: str) -> bool:
        """
        :param: word: string
        :return: bool
        
        search a prefix exist in Trie
        """
        return self._is_find(prefix) != None 

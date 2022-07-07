from collections import defaultdict
from typing import List 

class FileSystem:

    def __init__(self):
        self.root = TrieNode()

        
    def ls(self, path: str) -> List[str]:
        paths = path.split('/')
        curr = self.root
        
        for directory in paths:
            if directory:
                curr = curr.children[directory]
            
        if curr.isFile:
            return [directory]
        return sorted([directory for directory in curr.children.keys()])


    def mkdir(self, path: str) -> None:
        paths = path.split('/')
        curr = self.root
        
        for directory in paths:
            if directory:
                curr = curr.children[directory]

            
    def addContentToFile(self, filePath: str, content: str) -> None:
        paths = filePath.split('/')
        curr = self.root
        
        for directory in paths:
            if directory:
                curr = curr.children[directory]
            
        curr.content += content
        curr.isFile = True

        
    def readContentFromFile(self, filePath: str) -> str:
        paths = filePath.split('/')
        curr = self.root
        
        for directory in paths:
            if directory:
                curr = curr.children[directory]
            
        return curr.content
        
        
class TrieNode:
    def __init__(self):
        self.children = defaultdict(TrieNode)
        self.content = ''
        self.isFile = False

fileSystem = FileSystem()
print(fileSystem.ls("/"))                         # return []
print(fileSystem.mkdir("/a/b/c"))
print(fileSystem.addContentToFile("/a/b/c/d", "hello"))
print(fileSystem.ls("/"))                        # return ["a"]
print(fileSystem.readContentFromFile("/a/b/c/d"))  # return "hello"
# """
# This is Master's API interface.
# You should not implement it, or speculate about its implementation
# """
from typing import List
class Master:
    def guess(self, word: str) -> int:
        pass
    
class Solution:
    def findSecretWord(self, wordlist: List[str], master: 'Master') -> None:
        candidates = set(wordlist)
        while candidates:
            word = candidates.pop()
            match_num = master.guess(word)
            if match_num == len(word):
                return
            new_candidates = set()
            for candidate in candidates:
                if self.match(word, candidate) == match_num:
                    new_candidates.add(candidate)
            candidates = new_candidates
        return
        
    def match(self, word1, word2):
        count = 0
        for i in range(len(word1)):
            if word1[i] == word2[i]:
                count += 1
        return count
"""
BFS solution:
"""
from typing import List
from collections import deque
class Solution:
    def longestStrChain(self, words: List[str]) -> int:
        # construct predecessor mapping from prev to next word.
        # For example {"abc":["abcd", "axbc"]}
        prdc_dict = dict()
        for i in words:
            prdc_dict[i] = set()
        for word in words:
            for char in range(len(word)):
                new_word = word[:char] + word[char+1:]
                if new_word in prdc_dict:
                    prdc_dict[new_word].add(word)
        # Use BFS to get the max_len
        queue = deque(words)
        cur_len = 0
        visited = dict()
        while queue:
            cur_len += 1
            l = len(queue)
            for i in range(l):
                cur_word = queue.popleft()
                # If we have visited this word before and the length before was longer, then we skip the current word.
                if cur_word in visited and visited[cur_word] >= cur_len:
                    continue
                else:
                    visited[cur_word] = cur_len
                if cur_word in prdc_dict:
                    for new_word in prdc_dict[cur_word]:
                        queue.append(new_word)
        return cur_len
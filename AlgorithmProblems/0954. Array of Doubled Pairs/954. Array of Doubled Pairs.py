from collections import Counter
from typing import List
"""
Count occurence of each element and store into a dictionary.
Iterate through each key and remove it together with it's double.
The key might be the double of other elements, so we need to check it's parity.
1. If the key is odd, then we keep removing this key together with its double if double exists. 
And iterate to its double until there is no more double in the dictionary.
2. If the key is even, then divide the key by 2 and see if it's also existing in dictionary. If so we use the division result as the new key.
We keeping doing division until there is no smaller element existing in dictionary or the element is odd. Then we go to 1 and use the same method.
TC: O(N)
SC: O(N)
"""
class Solution:
    def canReorderDoubled(self, arr: List[int]) -> bool:
        array_dict = Counter(arr)
        for key in list(array_dict.keys()):
            if not array_dict[key]:
                continue
            if not self.remove_pairs(array_dict, key):
                return False
        return True
    
    def remove_pairs(self, array_dict, key):
        if key == 0:
            return not array_dict[key] % 2 == 1
        while key % 2 != 1 and key//2 in array_dict and array_dict[key//2] > 0:
            key //= 2
        while 2 * key in array_dict and array_dict[2*key] >= array_dict[key]:
            array_dict[2*key] -= array_dict[key]
            array_dict[key] = 0
            key *= 2
        if array_dict[key] != 0:
            return False
        return True
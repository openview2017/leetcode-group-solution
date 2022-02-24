
class SnapshotArray:
    # TC: O(N) SC: O(N)
    def __init__(self, length: int):
        self.snap_id = -1
        self.snap_dict = dict()
        self.update_dict = dict()  # Modification since last update.
        # initialize to make sure snap id 0 has value, so we don't need to add extra logic when snap 0 doesn't exist.
        for i in range(length):
            self.update_dict[i] = 0

    # TC: O(1)
    # update the modified dictionary since last update.
    def set(self, index: int, val: int) -> None:
        self.update_dict[index] = val
        return

    # TC: O(N)
    # update all changes in update_dict and reset update_dict.
    # after each snap, increment snap id by 1
    def snap(self) -> int:
        self.snap_id += 1
        for key, val in self.update_dict.items():
            if key in self.snap_dict:
                self.snap_dict[key].append((self.snap_id, val))
            else:
                self.snap_dict[key] = [(self.snap_id, val)]
        self.update_dict = dict()
        return self.snap_id

    # TC: O(logN)
    # find the most recent snap happened before or right at this snap id.
    def get(self, index: int, snap_id: int) -> int:
        if index not in self.snap_dict:
            return 0
        valid_snap_id = self.binary_search(self.snap_dict[index], snap_id)
        return self.snap_dict[index][valid_snap_id][1]
    
    # TC: O(logN)
    # Find the element smaller than or equal to target from right.
    def binary_search(self, array, target):
        l, r = 0, len(array)-1
        while l + 1 < r:
            mid = (l + r) // 2
            if array[mid][0] >= target:
                r = mid
            else:
                l = mid
        if array[r][0] <= target:
            return r
        else:
            return l
        
        


# Your SnapshotArray object will be instantiated and called as such:
# obj = SnapshotArray(length)
# obj.set(index,val)
# param_2 = obj.snap()
# param_3 = obj.get(index,snap_id)
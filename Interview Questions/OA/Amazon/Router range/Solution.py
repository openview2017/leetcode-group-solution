class ArrayNotAlignException(Exception):
    pass

class RouterRange:
    def getServedBuildings(self, buildingCount, routerLocation, routerRange):

        # Corner case
        if not buildingCount or not routerLocation or not routerRange:
            return 0
        if len(routerRange) != len(routerLocation):
            raise ArrayNotAlignException("Router location number and router range number is not equal.")

        # Track the boundaries where new services are provided or ended.
        update = [0 for _ in range(len(buildingCount)+1)]
        for i in range(len(routerLocation)):
            left = min(len(update)-1, max(0, routerLocation[i]-routerRange[i]))
            right = min(len(update)-1, max(0, routerLocation[i]+routerRange[i]+1))
            update[left] += 1
            update[right] -= 1

        # Update with result
        result = 0
        cur = 0
        for i in range(len(buildingCount)):
            cur += update[i]
            if buildingCount[i] <= cur:
                result += 1
        return result

if __name__ == "__main__":

    # Test case1
    buildingCount = [1, 2, 1, 2, 2]  
    routerLocation = [3, 1]  
    routerRange = [1, 2]  
    r = RouterRange()
    print(r.getServedBuildings(buildingCount, routerLocation, routerRange))
    print("Expected result: {}".format(3))

    # Test case2
    buildingCount = [3, 3, 3, 3, 3]  
    routerLocation = [1]  
    routerRange = [3]  
    r = RouterRange()
    print(r.getServedBuildings(buildingCount, routerLocation, routerRange))
    print("Expected result: {}".format(0))
# Router range

**reference link**: (https://leetcode.com/discuss/interview-question/1643403/Amazon-OA-SDE-1)

**Similar leetcode question**: 
[475. Heaters](https://leetcode.com/problems/heaters/)

Amazon has installed WiFi routers on the houses along a straight street. The city's buildings are
arranged linearly, denoted by indices 1 to n. There are m Amazon routers, and each has a certain
range associated with it. Router j installed at a certain building location can only provide Internet
to the buildings in the range [(i - routerRangeLin, (i+ routerRangelin] inclusive, where routerRangeli) is
the range parameter of router j. A building is considered to be served if the number of routers providing Internet to the building is greater than or equal to the number of people living in it. Given a list of the number of people living in each building, the locations of the buildings where the routers will be installed and each router's range, find the number of served buildings in the city.
Example
buildingCount = [1, 2, 1, 2, 2]
routerLocation = [3, 1]
routerRange = [1, 2]
There are 5 buildings with tenant counts shown in buildingCount. Routers are located in buildings 3
and 1 with ranges 1 and 2 as shown in
routerLocation and routerRange.

| Building | Router Count | Tenant Count | Served |
|----------|--------------|--------------|--------|
| 1        | 1            | 1            | Yes    |
| 2        | 2            | 2            | Yes    |
| 3        | 2            | 1            | Yes    |
| 4        | 1            | 2            | No     |
| 5        | 0            | 2            | No     |

The table above, explained:
The number of routers providing Internet to building 1 is 1, which is equal to the number of
people living here, so building 1 is served.
The number of routers providing Internet to building 2 is 2, which is equal to the number of
people living here, so building 2 is served.
• The number of routers providing Internet to building 3 is 2, which is greater than the number of people living here, so building 3 is served.
Building 4 only has coverage from 1 router, which is less than the number of people living there. The
building is unserved.
• Building 5 has no router coverage, so building 5 is unserved.
The 3 served buildings are 1, 2, and 3. Return 3.
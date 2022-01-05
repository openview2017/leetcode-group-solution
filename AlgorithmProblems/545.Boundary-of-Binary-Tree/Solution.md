### 545.Boundary-of-Binary-Tree

#### Definitoin :
```
- The left boundary is the set of nodes defined by the following:

- The root node's left child is in the left boundary. If the root does not have a left child, then the left boundary is empty.
- If a node in the left boundary and has a left child, then the left child is in the left boundary.
- If a node is in the left boundary, has no left child, but has a right child, then the right child is in the left boundary.
- The leftmost leaf is not in the left boundary.
```

#### Tree Example
```

              1
          /      \
          2       3
        /  \     /
        4   5    6
             \
             7

in above case:
        we can devide tree into 4 parts
            1. root
            2.left boundary(excluede leave node)
            3.leave node
            4.right boundary(excluded leave node)
So we will recursively find leftboundary, leave and rightboundary

```
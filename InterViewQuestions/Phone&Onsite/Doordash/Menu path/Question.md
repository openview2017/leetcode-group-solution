# Menu path

**Reference:**     
(https://leetcode.com/discuss/interview-question/1553862/doordash-phone-screen)  

**Definitions:**

- path is a / separate string describing the node. Example /Tres Potrillos/tacos/al_pastor  
- Values are all strings  
API spec:  
- get(path): String -> returns the value of the node at the given path  
- create(path, value) -> creates a new node and sets it to the given value. Should error out if the node already exists or if the node’s parent does not exist. That is /Sweetgreen/naan_roll cannot be created if /Sweetgreen has not already been created
- delete(path) -> deletes a node, but ONLY if it has no children.

**Solution:**  
Same as (https://leetcode.com/problems/design-file-system/)   
**Solution link**: [Link]: (/AlgorithmProblems/1166.Design%20File%20System/1166.Design-File-System.py)  
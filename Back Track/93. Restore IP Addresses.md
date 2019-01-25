## 93. Restore IP Addresses

Medium

Given a string containing only digits, restore it by returning all possible valid IP address combinations.

**Example:**

```
Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]
```

**Solution1:**

```java
//BackTrack DFS
//Time O(27) Space O(1)
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0)
            return result;
        dfs(result, s, new ArrayList<String>(), 0);
        return result;
    }
    
    public void dfs(List<String> result, String s, List<String> nums, int index){
        if (index == s.length() || nums.size() == 4){
            if (index == s.length() && nums.size() == 4){
                result.add(String.join(".", nums));
            }
        }else if (s.charAt(index) != '0'){
            for (int i = index + 1; i <= s.length(); i++){
                int value = Integer.parseInt(s.substring(index, i));
                if (value > 255)
                    break;
                nums.add(s.substring(index, i));
                dfs(result, s, nums, i);
                nums.remove(nums.size() - 1);
            }
        }else{
            nums.add("0");
            dfs(result, s, nums, index + 1);
            nums.remove(nums.size() - 1);
        }
    }
}
```

```python
class Solution(object):
    def restoreIpAddresses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        result = []
        if s is None or len(s) == 0:
            return result
        self.dfs(result, s, [], 0)
        return result
    
    def dfs(self, result, s, nums, index):
        if index == len(s) or len(nums) == 4:
            if index == len(s) and len(nums) == 4:
                result.append('.'.join(nums))
        elif s[index] != '0':
            for i in range(index + 1, len(s) + 1):
                v = int(s[index : i])
                if v > 255:
                    break
                nums.append(s[index:i])
                self.dfs(result, s, nums, i)
                nums.pop()
        else:
            nums.append('0')
            self.dfs(result, s, nums, index + 1)
            nums.pop()
        
```


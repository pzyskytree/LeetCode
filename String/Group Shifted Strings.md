### 249. Group Shifted Strings

Given a string, we can "shift" each of its letter to its successive letter, for example: `"abc" -> "bcd"`. We can keep "shifting" which forms the sequence:

```
"abc" -> "bcd" -> ... -> "xyz"
```

Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

**Example:**

```
Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
Output: 
[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
```

**Solution**:

```
class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<>();
        if (strings == null || strings.length == 0)
            return result;
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings){
            String start = getStartString(s);
            if (!map.containsKey(start)){
                map.put(start, new ArrayList<String>());
            }
            map.get(start).add(s);
        }
        result.addAll(map.values());
        return result;
    }
    public String getStartString(String s){
        if (s == null || s.length() == 0 || s.startsWith("a"))
            return s;
        StringBuilder result = new StringBuilder("a");
        for (int i = 1; i < s.length(); i++){
            result.append((char)('a' + (s.charAt(i) - s.charAt(0) + 26) % 26));
        }
        return result.toString();
    }
}
```




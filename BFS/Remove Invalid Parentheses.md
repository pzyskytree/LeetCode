### 301. Remove Invalid Parentheses

Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

**Note**: The input string may contain letters other than the parentheses ( and ).

Example 1:

```
 Input: "()())()"
 Output: ["()()()", "(())()"]
```

Example 2:

```
Input: "(a)())()"
Output: ["(a)()()", "(a())()"]
```

Example 3:

```
Input: ")("
Output: [""]
```



code: BFS:

```
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<String>();
        if (isValid(s)){
            result.add(s);
            return result;
        }    
        Queue<String> queue = new LinkedList<String>();
        queue.offer(s);
        Set<String> visited = new HashSet<String>();
        visited.add(s); 
        while (!queue.isEmpty()){
            String str = queue.poll();
            if (isValid(str)){
               break;
            }
            for (int i = 0; i < str.length(); i++){
                if (str.charAt(i) == ')' || str.charAt(i) == '('){
                    String subs = str.substring(0, i) + str.substring(i + 1);
                    if (!visited.contains(subs)){
                        if (isValid(subs)){
                            result.add(subs);
                        }
                        queue.offer(subs);
                        visited.add(subs);
                    }
                }
            }
        }
        return result;
    }
    public boolean isValid(String s){
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(')
                count++;
            if (s.charAt(i) == ')')
                count--;
            if (count < 0)
                return false;
        }
        return count == 0;
    }
}
```




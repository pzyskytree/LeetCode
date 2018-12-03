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



code: DFS:

```
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<String>();
        dfs(result, s, 0, 0, new char[]{'(', ')'});
        return result;
    }
    
    public void dfs(List<String> result, String s, int startI, int startJ, char[] ps){
        int sum = 0;
        for (int i = startI; i < s.length(); i++){
            if (s.charAt(i) == ps[0])
                sum++;
            if (s.charAt(i) == ps[1])
                sum--;
            if (sum < 0){
                for (int k = startJ; k <= i; k++){
                    if (s.charAt(k) == ps[1] && 
                       (k == 0 || s.charAt(k - 1) != s.charAt(k))){
                        dfs(result, s.substring(0, k) + s.substring(k + 1), i, k, ps);
                    }
                }
                return;
            }
        }
        s = new StringBuilder(s).reverse().toString();
        if (ps[0] == '('){
            dfs(result, s, 0, 0, new char[]{')', '('});
        }else{
            result.add(s);
        }
        
    }
}
```




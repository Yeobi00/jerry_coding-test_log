class Solution {
    public String solution(String p) {
        return dfs(p);
    }
    
    String dfs(String str) {
        if (str.length() == 0) return "";
        
        int balanced = 0;
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') balanced++;
            else if (c == ')') balanced--;
            
            if (balanced == 0) {
                String u = str.substring(0, i + 1);
                String v = str.substring(i + 1);
                
                if (isCorrect(u)) {
                    return u.concat(dfs(v));
                }
                
                String newStr = "(" + dfs(v) + ")";
                
                char[] newU = new char[u.length() - 2];
                for (int j = 1; j < u.length() - 1; j++) {
                    char ch = u.charAt(j);
                    if (ch == '(') newU[j - 1] = ')';
                    else if (ch == ')') newU[j - 1] = '(';
                }
                
                return newStr.concat(new String(newU));
            }
        }
        
        return "";
    }
    
    boolean isCorrect(String s) {
        int balanced = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') balanced++;
            else if (s.charAt(i) == ')') balanced--;
            
            if (balanced < 0) return false;
        }
        if (balanced != 0) return false;
        
        return true;
    }
}
import java.util.*;

class Solution {
    public int[] solution(String s) {
        String str = s.substring(2, s.length() - 2);
        String[] sets = str.split("\\},\\{");
        
        String[][] parsed = new String[sets.length][];
        for (int i = 0; i < sets.length; i++) {
            parsed[i] = sets[i].split(",");
        }
        
        Arrays.sort(parsed, (a, b) -> a.length - b.length);
        
        Set<String> set = new HashSet<>();
        
        int[] result = new int[parsed.length];
        
        for (int i = 0; i < parsed.length; i++) {
            for (int j = 0; j < parsed[i].length; j++) {
                String num = parsed[i][j];
                
                if (!set.contains(num)) {
                    result[i] = Integer.parseInt(num);
                    set.add(num);
                    break;
                }
            }
        }
        
        return result;
    }
}
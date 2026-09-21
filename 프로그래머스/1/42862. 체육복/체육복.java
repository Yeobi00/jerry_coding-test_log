import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        int[] clothes = new int[n + 1];
        Arrays.fill(clothes, 1);
        
        for (int l: lost) {
            clothes[l]--;
        }
        
        for (int r: reserve) {
            clothes[r]++;
        }
        
        int cnt = 0;
        
        for (int i = 1; i <= n; i++) {
            if (clothes[i] > 0) {
                cnt++;
                continue;
            }
            
            if (clothes[i - 1] > 1) {
                clothes[i - 1]--;
                clothes[i]++;
                cnt++;
                continue;
            }
            
            if (i < n && clothes[i + 1] > 1) {
                clothes[i + 1]--;
                clothes[i]++;
                cnt++;
            }
        }
        
        return cnt;
    }
}
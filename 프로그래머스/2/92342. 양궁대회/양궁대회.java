class Solution {
    int best = 0;
    int[] bestArr = null;
    int[] info;
    
    public int[] solution(int n, int[] info) {
        this.info = info;
        dfs(0, n, new int[11]);
        return bestArr == null ? new int[]{-1} : bestArr;
    }
    
    void dfs(int idx, int left, int[] lion) {
        if (idx == 10) {
            lion[10] = left;
            evaluate(lion);
            lion[10] = 0;
            return;
        }
        
        int need = info[idx] + 1;
        if (need <= left) {
            lion[idx] = need;
            dfs(idx + 1, left - need, lion);
            lion[idx] = 0;
        }
        dfs(idx + 1, left, lion);
    }
    
    void evaluate(int[] lion) {
        int diff = 0;
        for (int i = 0; i < 10; i++) {
            if (lion[i] == 0 && info[i] == 0) continue;
            if (lion[i] > info[i]) diff += 10 - i;
            else diff -= 10 - i;
        }
        
        if (diff <= 0) return;
        if (diff > best || (diff == best && lowerIsBigger(lion, bestArr))) {
            best = diff;
            bestArr = lion.clone();
        }
    }
    
    boolean lowerIsBigger(int[] a, int[] b) {
        for (int i = 10; i >= 0; i--) {
            if (a[i] != b[i]) return a[i] > b[i];
        }
        return false;
        
    }
}
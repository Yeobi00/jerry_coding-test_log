class Solution {
    int max;
    boolean[] used;
    
    public int solution(int k, int[][] dungeons) {
        max = 0;
        used = new boolean[dungeons.length];
        dfs(dungeons, k, 0);
        return max;
    }
    
    void dfs(int[][] dungeons, int hp, int count) {
        max = Math.max(count, max);
        
        for (int i = 0; i < dungeons.length; i++) {
            if (used[i]) continue;
            if (hp < dungeons[i][0]) continue;
            
            used[i] = true;
            dfs(dungeons, hp - dungeons[i][1], count + 1);
            used[i] = false;
        }
    }
}
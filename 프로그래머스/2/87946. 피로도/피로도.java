class Solution {
    static int answer;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        
        visited = new boolean[dungeons.length];
        
        dfs(k, 0, dungeons);
        
        return answer;
    }
    
    private void dfs(int curState, int count, int[][] dungeons) {
        answer = Math.max(answer, count);
        
        for (int i = 0; i < dungeons.length; i++) {
            int required = dungeons[i][0];
            int cost = dungeons[i][1];
            
            if (!visited[i] && curState >= required) {
                visited[i] = true;
                dfs(curState - cost, count + 1, dungeons);
                visited[i] = false;
            }
        }
    }
}
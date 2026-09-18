class Solution {
    public int solution(int[][] sizes) {
        int w = 0, h = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            int curW = Math.max(sizes[i][0], sizes[i][1]);
            int curH = Math.min(sizes[i][0], sizes[i][1]);
            
            if (curW > w) {
                w = curW;
            }
            
            if (curH > h) {
                h = curH;
            }
        }
        
        return w * h;
    }
}


class Solution {
    public int[] solution(int brown, int yellow) {
        
        for (int i = 1; i <= yellow; i++) {
            
            int max;
            
            if (yellow % i == 0) {
                int lenA = i;
                int lenB = yellow / i;
                max = Math.max(lenA, lenB);
                
                if ((lenA + 2) * (lenB + 2) == (brown + yellow)) {
                    int width = Math.max(lenA, lenB) + 2;
                    int height = Math.min(lenA, lenB) + 2;
                    
                    return new int[]{width, height};
                }
            }   
        }
        
        return new int[]{brown, yellow};
    }
}
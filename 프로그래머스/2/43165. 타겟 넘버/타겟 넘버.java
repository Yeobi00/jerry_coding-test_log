class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    private int dfs(int[] numbers, int target, int sum, int depth) {
        if (depth == numbers.length) {
            return sum == target ? 1: 0;
        }
        
        int plus = dfs(numbers, target, sum + numbers[depth], depth + 1);
        int minus = dfs(numbers, target, sum - numbers[depth], depth + 1);
        
        return plus + minus;
    }
}
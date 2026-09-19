import java.util.*;

class Solution {
    
    Set<Integer> candidates = new HashSet<>();
    boolean[] used;
    
    public int solution(String numbers) {
        used = new boolean[numbers.length()];
        makeNumbers(numbers, "");
        
        int answer = 0;
        
        for (int c: candidates) {
            if (isPrime(c)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private void makeNumbers(String numbers, String current) {
        if (!current.isEmpty()) {
            candidates.add(Integer.parseInt(current));
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (used[i]) {
                continue;
            }
            
            used[i] = true;
            makeNumbers(numbers, current + numbers.charAt(i));
            used[i]= false;
        }
    }
    
    private boolean isPrime(int number) {
        if (number < 2) return false;
        
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}
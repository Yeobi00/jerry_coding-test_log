class Solution {
    public String solution(String number, int k) {
        char[] stack = new char[number.length()];
        int top = 0;
        
        for (char digit : number.toCharArray()) {
            while (
                top > 0 &&
                k > 0 &&
                stack[top - 1] < digit
            ) {
                top--;
                k--;
            }
            
            stack[top++] = digit;
        }
        
        top -= k;
        
        return new String(stack, 0, top);
    }
}


class Solution {
    public boolean isValid(String s) {
        Deque <Character> stack = new ArrayDeque<>();

        // 遇到open bracket就push到stack里面
        for(char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // 遇到close brack就和stack的顶部做对比
            if (c == ')'){
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false; 
                }
            }
            if (c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }    
            }
            if (c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }    
}
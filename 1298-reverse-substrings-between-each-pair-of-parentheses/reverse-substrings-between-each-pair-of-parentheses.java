class Solution {
    public String reverseParentheses(String s) {
        s = '(' + s + ')';
        Stack<Character> stack1 = new Stack<>();
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        for(int i=0; i<arr.length; i++){
            while(arr[i]!=')'){
                stack1.push(arr[i]);
                i++;
            }
            while(stack1.peek()!='('){
                sb.append(stack1.pop());
            }
            stack1.pop();
            for(int j = 0; j < sb.length(); j++) {
                stack1.push(sb.charAt(j));
            }
            sb.setLength(0);
        }
        while(!stack1.isEmpty()){
            sb.append(stack1.pop());
        }
        return sb.toString();
    }
}
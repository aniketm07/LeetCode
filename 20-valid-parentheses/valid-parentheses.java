class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0){
            return false;
        }
        Stack<Character> stack = new Stack();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                stack.push(s.charAt(i));   
            }else{
                if(stack.isEmpty() || s.charAt(i)!=getChar(stack.pop())){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    
    public Character getChar(Character c){
        switch(c){
            case '{': return '}';
            case '(': return ')';
            case '[': return ']';
            default : return null;
        }
    }
}
class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        List<Character> list = Arrays.asList('{', '[', '(');
        Map<Character,Character> map = new HashMap<>() {{
            put('}', '{');
            put(')', '(');
            put(']', '[');
        }};
        
        for(char ch : s.toCharArray()){
            if(list.contains(ch)){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                Character pop = stack.pop();
                if(map.get(ch)!=pop){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
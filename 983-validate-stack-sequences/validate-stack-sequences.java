class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int j=0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<pushed.length; i++){
            if(pushed[i]!=popped[j]){
                stack.push(pushed[i]);
            }else{
                j++;
                while(j<popped.length && !stack.isEmpty() && popped[j]==stack.peek()){
                    stack.pop();
                    j++;
                }
            }
        }
        return stack.isEmpty();
    }
}
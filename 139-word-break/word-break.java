class Solution {
    public boolean wordBreak(String s, List<String> words) {
        boolean[] dpArr = new boolean[s.length()];
        boolean[] visited = new boolean[s.length()];
        return dp(s, words, 0, dpArr, visited);
    }

    public boolean dp(String s, List<String> words, int start, boolean[] dpArr, boolean[] visited) {
        if(start==s.length()){
            return true;
        }
        if(visited[start]){
            return dpArr[start];
        }
        boolean flag = false;
        for(int i=0; i<words.size(); i++){
            String word = words.get(i);
            int end = start + word.length();
            if(end<= s.length()){
                if(s.substring(start, end).equals(word)){
                    visited[start] = true;
                    if(dp(s, words, end, dpArr, visited)){
                        flag = true;
                        break;
                    }
                } 
                    
            }
        }
        dpArr[start] = flag;
        return flag;
    }
}
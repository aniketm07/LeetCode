class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        int left = 0;
        int right = 0;
        int max = 1;
        while(right<s.length()){
            if(checkExists(s.substring(left, right), s.charAt(right)) == -1){
                right++;
            }else{
                while(s.charAt(left)!=s.charAt(right)){
                    left++;
                }
                left++;
            }
            max = Math.max(right-left, max);
        }
        return max;
    }

    public int checkExists(String s, char ch){
        return s.indexOf(ch);
    }
}
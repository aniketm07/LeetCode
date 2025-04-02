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
            System.out.println("Substring: " + s.substring(left, right) + " For Character: " + s.charAt(right));
            System.out.println("CheckExist: " + checkExists(s.substring(left, right), s.charAt(right)));
            if(!checkExists(s.substring(left, right), s.charAt(right))){
                right++;
            }else{
                while(s.charAt(left)!=s.charAt(right) && left<=right){
                    left++;
                }
                left++;
            }
            System.out.println("Left: "+ left + " Right: " + right);
            System.out.println();
            System.out.println();
            max = Math.max(right-left, max);
        }
        return max;
    }

    public boolean checkExists(String s, char ch){
        return s.indexOf(ch)==-1 ? false : true;
    }
}
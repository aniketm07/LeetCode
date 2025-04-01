class Solution {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()){
            return true;
        }
        s = s.toLowerCase();
        int l = 0;
        int r = s.length()-1;
        while(l<=r){
            if(!Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }else if(!Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }else{
                if(s.charAt(l)==s.charAt(r)){
                    l++;
                    r--;
                }else{
                    return false;
                }
            }
        }
        return true;

    }
}
class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder st = new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            if(Character.isLetterOrDigit(s.charAt(i)))
            {
                st.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        
        StringBuilder st1 = new StringBuilder(st.toString());
        st1.reverse();
        
        if(st.toString().equals(st1.toString()))
            return true;
        else return false;

    }
}
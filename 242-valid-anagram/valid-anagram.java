class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[123];
        if(s.length() != t.length()){
            return false;
        }
        for(int i=0; i<s.length(); i++){
            Character ch = s.charAt(i);
            count[ch]++;
        }

        for(int i=0; i<t.length(); i++){
            Character ch = t.charAt(i);
            if(count[ch]<=0){
                return false;
            }
            count[ch]-=1;
        }
        return true;
    }
}
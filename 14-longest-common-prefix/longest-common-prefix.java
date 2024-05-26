class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        String smallestString = strs[0];
        
        for(int i=1;i<strs.length;i++){
            if(smallestString.length() > strs[i].length()){
                smallestString = strs[i];
            }
        }
        
        for(int i=0;i<smallestString.length();i++){
            for(int j=0;j<strs.length;j++){
                if(smallestString.charAt(i) != strs[j].charAt(i)){
                    return sb.toString();
                }
            }
            sb.append(smallestString.charAt(i));
        }
        return sb.toString();
    }
}
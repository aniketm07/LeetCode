class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        char[] split = allowed.toCharArray();
        boolean[] characters = new boolean[26];
        for(char character : split){
            characters[character-97] = true;
        }
        int count = 0;
        for(String word : words){
            if(isPresent(word, characters)){
                count++;
            }
        }
        return count;
    }

    public boolean isPresent(String word, boolean[] characters){
        for(int i=0;i<word.length();i++){
            if(!characters[word.charAt(i)-97]){
                return false;
            }
        }
        return true;
    }
}
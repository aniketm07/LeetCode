class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int max = 0;
        int[] freq = new int[26];
        int res = 0;

        for(int r=0;r<s.length();r++){
            char right = s.charAt(r);
            freq[right - 'A']++;
            max = Math.max(max, freq[right - 'A']);
            // 
            while(r-l+1-max > k){
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}
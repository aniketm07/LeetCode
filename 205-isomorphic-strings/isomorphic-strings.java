class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map = new HashMap<>();
        Map<Character,Character> map2 = new HashMap<>();
        char ch1,ch2;
        for(int i=0;i<s.length();i++) {
            ch1 = s.charAt(i);
            ch2 = t.charAt(i); 
            if(map.containsKey(ch1)) {
                if (ch2 != map.get(ch1)) {
                    return false;
                }
            }
            else if(map2.containsKey(ch2)) {
                return false;
            }
            else {
                map.put(ch1,ch2);
                map2.put(ch2,ch1);
            }

        }
        return true;
    }
}

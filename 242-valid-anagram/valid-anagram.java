class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            Character ch = s.charAt(i);
            Integer count = map.getOrDefault(ch, 0);
            map.put(ch, count+1);
        }

        for(int i=0; i<t.length(); i++){
            Character ch = t.charAt(i);
            if(!map.containsKey(ch)){
                return false;
            }
            Integer count = map.get(ch);
            if(count > 0){
                map.put(ch, count-1);
            }else{
                return false;
            }
        }

        // for(Integer i : map.values()){
        //     if(i!=0){
        //         return false;
        //     }
        // }
        return true;
    }
}
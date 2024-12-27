class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> finalAns = new ArrayList<>();
        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
        for(int i=0; i<strs.length; i++){
            String s = strs[i];
            Map<Character, Integer> charMap = createCharMap(s);
            List<String> list = map.getOrDefault(charMap, new ArrayList<String>());
            list.add(s);
            map.put(charMap, list);
        }
        for (Map.Entry<Map<Character, Integer>, List<String>> entry : map.entrySet()) {
            finalAns.add(entry.getValue());
        }
        return finalAns;
    }

    private Map<Character, Integer> createCharMap(String str){
        Map<Character, Integer> charMap = new HashMap<>();
        for(char ch : str.toCharArray()){
            Integer count = charMap.getOrDefault(ch, 0);
            charMap.put(ch, count+1);
        }
        return charMap;
    }
}
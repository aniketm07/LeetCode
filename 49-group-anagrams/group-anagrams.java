class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedString = String.valueOf(charArray);
            List<String> list = map.getOrDefault(sortedString, new ArrayList<>());
            list.add(s);
            map.put(sortedString, list);
        }

        List<List<String>> output = new ArrayList<>();
        for(List<String> list : map.values()){
            output.add(list);
        }
        return output;
    }
}
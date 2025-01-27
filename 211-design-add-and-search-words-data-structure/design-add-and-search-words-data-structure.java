import java.util.regex.Matcher;
import java.util.regex.Pattern;

class WordDictionary {

    Map<Integer, HashMap<Character, HashSet<String>>> map;

    public WordDictionary() {
       map = new HashMap<>();
    }
    
    public void addWord(String word) {
        HashMap<Character, HashSet<String>> map2 = map.getOrDefault(word.length(), new HashMap<>());
        HashSet<String> set = map2.getOrDefault(word.charAt(0), new HashSet<>());
        set.add(word);
        map2.put(word.charAt(0), set);
        map.put(word.length(), map2);
    }
    
    public boolean search(String word) {
        Map<Character, HashSet<String>> map2 = map.get(word.length());
        if(map2 != null){
            Set<String> set = word.charAt(0) == '.' 
                          ? map2.values().stream().flatMap(Set::stream).collect(Collectors.toSet()) 
                          : map2.get(word.charAt(0));
            if(set!=null && !set.isEmpty()){
                for (String s : set) {
                    boolean flag = true;
                    for(int i=0; i<s.length(); i++){
                        if(word.charAt(i)!='.' && word.charAt(i)!=s.charAt(i)){
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
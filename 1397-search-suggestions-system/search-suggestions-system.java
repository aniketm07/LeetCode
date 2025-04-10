class Solution {

    class Trie {
        Trie[] next;
        List<String> words;
        Trie() {
            words = new ArrayList();
            next = new Trie[26];
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        
        Trie root = new Trie();
        for (String prod : products) {
            Trie n = root;
            for (char ch : prod.toCharArray()) {
                int i = ch - 'a';
                if (n.next[i] == null) {
                    n.next[i] = new Trie();
                }
                n = n.next[i];
                if (n.words.size() < 3)
                    n.words.add(prod);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        Trie n = root;
        for(int i=0; i<searchWord.length(); i++){
            n = n.next[searchWord.charAt(i) - 'a'];
            if(n==null){
                for(int j=i; j<searchWord.length(); j++){
                    ans.add(Collections.EMPTY_LIST);
                }
                break;
            }
            ans.add(n.words);
        }
        return ans;
    }
}
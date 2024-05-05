class Solution {

    
    public List<List<String>> partition(String s) {
        List<List<String>> finalAns = new ArrayList<>();
        List<String> currentList = new ArrayList<>();
        recursionCall(s, 0, currentList, finalAns);
        return finalAns;
    }

    public static void recursionCall(String s, int index, List<String> currentList, List<List<String>> finalAns){
        if(index >= s.length()){
            finalAns.add(new ArrayList<>(currentList));
            return;
        }
        for(int i=index+1; i<=s.length(); i++){
            String substr = s.substring(index, i);
            if(isPalindrome(substr)){
                currentList.add(substr);
                recursionCall(s, i, currentList, finalAns);
                currentList.remove(currentList.size()-1);
            }
        }
    }

    public static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
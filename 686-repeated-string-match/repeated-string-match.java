class Solution {
    public int repeatedStringMatch(String a, String b) {
        int val = (int)(b.length() / a.length());
        String tryString = String.join("", Collections.nCopies(val, a));
        for(int i=val;i<val+3;i++){
            if(tryString.contains(b)){
                return i;
            }
            tryString+=a;
        }
        return -1;
    }
}
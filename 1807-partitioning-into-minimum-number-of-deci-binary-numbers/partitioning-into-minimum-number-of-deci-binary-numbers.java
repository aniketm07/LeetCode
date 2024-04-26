class Solution {
    public int minPartitions(String n) {
        int max = -1;
        for(int i=0; i<n.length(); i++){
            int ch = n.charAt(i) - '0';
            max = ch > max ? ch : max;
        }
        return max;
    }
}
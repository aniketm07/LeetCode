class Solution {
    public int minimumOperations(int[] nums) {
        int[] cnt = new int[101];
        int res = 0;
        for (int num : nums) {
            if (num != 0) {
                cnt[num]++;
                if (cnt[num] == 1) {
                    res++;
                }
            }
        }
        return res;
    }
}
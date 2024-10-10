class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int i=0;
        int[] ans = new int[nums1.length];
        for(int val1 : nums1){
            boolean flag = false;
            int ansVal = -1;
            for(int val2 : nums2){
                if(val1 == val2 && !flag){
                    flag=true;
                }else if(flag && val2 > val1){
                    ansVal = val2;
                    break;
                }
            }
            ans[i++] = ansVal;
        }
        return ans;
    }
}
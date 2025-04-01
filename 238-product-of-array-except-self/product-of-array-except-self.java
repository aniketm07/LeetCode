class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[nums.length];
        Arrays.fill(output, 1);
        for(int i=1;i<n;i++){
            output[i] = nums[i-1]*output[i-1];
        }
        int postFix = 1;
        for(int i=n-1;i>=0;i--){
            output[i] = output[i]*postFix;
            postFix = postFix*nums[i];
        }
        return output;
    }
}
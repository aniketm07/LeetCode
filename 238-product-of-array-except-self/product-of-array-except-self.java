class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[nums.length];
        prefix[0] = 1;
        int[] postfix = new int[nums.length];
        postfix[n-1] = 1;
        int[] output = new int[nums.length];

        for(int i=1;i<n;i++){
            prefix[i] = nums[i-1]*prefix[i-1];
        }
        for(int i=n-2;i>=0;i--){
            postfix[i] = nums[i+1]*postfix[i+1];
        }
        // for(int i=0;i<n;i++){
        //     System.out.print(prefix[i] + ", ");
        // }
        // System.out.println("");
        // for(int i=0;i<n;i++){
        //     System.out.print(postfix[i] + ", ");
        // }
        for(int i=0;i<n;i++){
            output[i] = prefix[i]*postfix[i];
        }
        return output;
    }
}
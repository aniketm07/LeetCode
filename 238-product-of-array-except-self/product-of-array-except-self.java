class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        int[] output = new int[nums.length];

        for(int i=0;i<n;i++){
            if(i==0){
                prefix[i] = nums[i];
            }else{
                prefix[i] = nums[i]*prefix[i-1];
            }
        }
        for(int i=n-1;i>=0;i--){
            if(i==n-1){
                postfix[i] = nums[i];
            }else{
                postfix[i] = nums[i]*postfix[i+1];
            }
        }
        // for(int i=0;i<n;i++){
        //     System.out.print(prefix[i] + ", ");
        // }
        // System.out.println("");
        // for(int i=0;i<n;i++){
        //     System.out.print(postfix[i] + ", ");
        // }
        for(int i=0;i<n;i++){
            if(i==0){
                output[i] = postfix[i+1];
            }else if(i==n-1){
                output[i] = prefix[i-1];
            }else{
                output[i] = prefix[i-1] * postfix[i+1];
            }
        }
        return output;
    }
}
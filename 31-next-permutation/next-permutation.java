class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length == 1) {
            return;
        }
        int breakPoint=-1;
        for(int i=nums.length-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                breakPoint = i;
                break;
            }
        }
        if(breakPoint==-1){
            reverse(nums, 0, nums.length - 1);
            return;
        }

        for(int i=nums.length-1;i>breakPoint;i--){
            if(nums[i] > nums[breakPoint]){
                swap(nums, i, breakPoint);
                break;
            }
        }
        reverse(nums, breakPoint + 1, nums.length - 1 );
    }

    public void reverse(int[] A, int i, int j) {
        while(i < j) swap(A, i++, j--);
    }
    
    public int[] swap(int nums[], int index, int breakPoint){
        nums[breakPoint] = nums[breakPoint] ^ nums[index];  
        nums[index] = nums[breakPoint] ^ nums[index];  
        nums[breakPoint] = nums[breakPoint] ^ nums[index];
        return nums;
    }
}
class Solution {
    public int removeElement(int[] nums, int val) {
        int p = nums.length-1;
        int i = 0;
        int count = 0;
        while(i<=nums.length-1 && nums[i]!=-1){
            if(nums[i] == val){
                nums[i] = nums[p];
                nums[p] = -1;
                p--;
                count++;
            }else{
                i++;
            }
        }
        return nums.length - count;
    }
}
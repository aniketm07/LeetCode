class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int max = 1;
        int current = 0;
        int lastNumber = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]-1 == lastNumber){
                current++;
                max = current > max ? current : max;
            }else{
                if(nums[i]==lastNumber){
                    continue;
                }else{
                    current = 1;
                }
            }
            lastNumber = nums[i];
        }
        return max;
    }
}
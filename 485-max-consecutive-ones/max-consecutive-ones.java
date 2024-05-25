class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int counter = 0;
        int maxCounter =0;
        for(int i=0; i<nums.length ; i++){
            if(nums[i]==1){
                counter++;
            }else{
                if(counter > maxCounter){
                    maxCounter = counter;
                }
                counter = 0;
            }
        }
        if(counter > maxCounter){
            maxCounter = counter;
                }
        
        return maxCounter;
        
        
        
        
    }
}
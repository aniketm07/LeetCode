class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 2;
        while (low<=high){
            int mid = (low+high) >> 1;
            // in ideal scenarion, even element should occur as 1st element
            // and the odd element should be 2nd element
            if(mid%2==0){
                if(nums[mid]==nums[mid+1]){
                    low=mid+2;
                }else{
                    high=mid-1;
                }
            } else{
               if(nums[mid]==nums[mid-1]){
                   low=mid+1;
               }else{
                   high=mid-2;
               }
            }
        }
        return nums[low];
    }
}
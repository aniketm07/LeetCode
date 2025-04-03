class Solution {
    public int findMin(int[] nums) {
        int res = Integer.MAX_VALUE;
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[low] <= nums[mid]){
                res = Math.min(res, nums[low]);
                low = mid+1;
            }else{
                res = Math.min(res, nums[mid]);
                high = mid-1;
            }
            // res = Math.min(res, nums[mid]);
            // if(nums[mid] >= nums[low]){
            //     low = mid+1;
            // }else{
            //     high = mid-1;
            // }
        }
        return res;
    }
}
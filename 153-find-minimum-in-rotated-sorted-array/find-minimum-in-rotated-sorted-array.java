class Solution {
    public int findMin(int[] nums) {
        int res = Integer.MAX_VALUE;
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            // System.out.println("Low: " + low + " High: " + high);
            if(nums[low] < nums[high]){
                return Math.min(nums[low], res);
            }
            int mid = low + (high - low)/2;
            res = Math.min(res, nums[mid]);
            if(nums[mid] >= nums[low]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return res;
    }
}
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int lower = -1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                lower = mid;
                high = mid-1;
            }else if(nums[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        int higher = -1;
        low = 0;
        high = nums.length-1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                higher = mid;
                low = mid+1;
            }else if(nums[mid] > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        int[] arr = new int[2];
        arr[0] = lower;
        arr[1] = higher;
        return arr;
    }
}
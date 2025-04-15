class Solution {
    public int minimumSwaps(int[] nums) {
        int n = nums.length;
        int lIndex = 0;
        int hIndex = 0;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(nums[i] < low){
                lIndex = i;
                low = nums[i];
            }
            if(nums[i] >= high){
                hIndex = i;
                high = nums[i];
            }
        }
        int count = 0;
        if(lIndex > hIndex){
            hIndex++;
        }

        while(lIndex != 0){
            swap(lIndex, lIndex-1, nums);
            lIndex--;
            count++;
        }

        while(hIndex!=n-1){
            swap(hIndex, hIndex+1, nums);
            hIndex++;
            count++;
        }
        return count;
    }

    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
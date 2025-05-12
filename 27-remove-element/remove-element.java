class Solution {
    public int removeElement(int[] nums, int val) {
        int p = nums.length-1;
        int i = 0;
        int count = 0;
        while(i<=nums.length-1 && nums[i]!=-1){
            System.out.println("At i=" + i);
            if(nums[i] == val){
                nums[i] = nums[p];
                nums[p] = -1;
                p--;
                count++;
            }else{
                i++;
            }
            printArray(nums);
        }
        return nums.length - count;
    }

    public void printArray(int[] nums){
        for(int i : nums){
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
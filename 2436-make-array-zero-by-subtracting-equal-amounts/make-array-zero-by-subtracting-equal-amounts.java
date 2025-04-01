class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                hashSet.add(nums[i]);
            }   
        }
        return hashSet.size();
    }
}
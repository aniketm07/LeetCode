class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> finalList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        powerSet(nums, 0, finalList, list);
        return finalList;
    }
    
    public void powerSet(int[] nums, int index, List<List<Integer>> finalList, List<Integer> list){
        if(index > nums.length - 1){
            if(!finalList.contains(list)){
                finalList.add(list);
            }
            return;
        }
        List<Integer> newList = new ArrayList<>(list);
        newList.add(nums[index]);
        powerSet(nums, index+1, finalList, list);
        powerSet(nums, index+1, finalList, newList);
    }
}
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> finalAns = new ArrayList<>();
        boolean[] pickNotPick = new boolean[nums.length];
        recursiveCall(nums, pickNotPick, finalAns, new ArrayList<>());
        return finalAns;
    }

    public void recursiveCall(int[] nums, boolean[] pickNotPick, List<List<Integer>> finalAns, List<Integer> list){
        if(list.size() == nums.length){
            finalAns.add(list);
            return;
        }
        for(int i=0; i<pickNotPick.length; i++){
            if(!pickNotPick[i]){
                pickNotPick[i] = true;
                List<Integer> newList = new ArrayList<>(list);
                newList.add(nums[i]);
                recursiveCall(nums, pickNotPick, finalAns, newList);
                pickNotPick[i] = false;
            }
        }
    }
}
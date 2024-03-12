class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> finalAns = new ArrayList<>();
        recursiveCall(candidates, 0, finalAns, new ArrayList<>(), target);
        return finalAns;
    }

    public void recursiveCall(int[] candidates, int index, List<List<Integer>> finalAns, List<Integer> list, int target){
        if(target == 0){
            finalAns.add(list);
            return;
        }
        if(index > candidates.length-1){
            return;
        }
        if(target > 0){
            List<Integer> newList = new ArrayList<>(list);
            newList.add(candidates[index]);
            recursiveCall(candidates, index, finalAns, newList, target-candidates[index]);
            recursiveCall(candidates, index+1, finalAns, list, target);
        }
    }
}
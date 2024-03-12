class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> finalAns = new ArrayList<>();
        recursiveCall(candidates, 0, finalAns, new ArrayList<>(), target);
        return finalAns;
    }

    public void recursiveCall(int[] candidates, int index, List<List<Integer>> finalAns, List<Integer> list, int target){
        
        if(index > candidates.length-1 || (index < candidates.length && candidates[index] > target)){
            return;
        }
        List<Integer> newList = new ArrayList<>(list);
        newList.add(candidates[index]);
        if(target==candidates[index]){
            finalAns.add(newList);
            return;
        }
        recursiveCall(candidates, index, finalAns, newList, target-candidates[index]);
        recursiveCall(candidates, index+1, finalAns, list, target);
    }
}
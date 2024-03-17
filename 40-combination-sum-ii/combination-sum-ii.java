class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> finalAns = new ArrayList<>();
        recursiveCall(0, target, candidates, new ArrayList<>(), finalAns);
        return finalAns;
    }

    public void recursiveCall(int index, int remainingSum, int[] candidates, List<Integer> currentList, List<List<Integer>> finalAns){
        if(remainingSum==0){
            finalAns.add(new ArrayList<>(currentList));
            return;
        }
        
        if(index==candidates.length){
            return;
        }
        int prev = -1;
        for(int i=index;i<candidates.length;i++){
            if(candidates[i]>remainingSum){
                break;
            }
            if(prev!=candidates[i]){
                prev = candidates[i];
                currentList.add(candidates[i]);
                recursiveCall(i+1, remainingSum-candidates[i], candidates, currentList, finalAns);
                currentList.remove(currentList.size()-1);
            }
        }
    }
}
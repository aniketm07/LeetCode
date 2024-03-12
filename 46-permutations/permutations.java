class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> finalAns = new ArrayList<>();
        recursiveCall(nums, 0, finalAns);
        return finalAns;
    }

    public void recursiveCall(int[] nums, int index, List<List<Integer>> finalAns){
        if(index > nums.length-1){

            List<Integer> list = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                list.add(nums[i]);
            }
            finalAns.add(list);
            return;
        }
        for(int i=index;i<nums.length;i++){
            swap(nums, i, index);
            recursiveCall(nums, index+1, finalAns);
            swap(nums, i, index);
        }

    }

    public static final void swap (int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
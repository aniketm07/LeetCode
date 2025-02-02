class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer>[] bucketList = new ArrayList[nums.length+1];
        int[] ans = new int[k];
        int j=0;
        map.entrySet().stream().forEach(element -> {
            if (bucketList[element.getValue()]==null)
                bucketList[element.getValue()] = new ArrayList<>();
            bucketList[element.getValue()].add(element.getKey());
        });
        for(int i=bucketList.length-1; i>=0 && j<k; i--){
            if(bucketList[i]!=null){
                for(int num : bucketList[i]){
                    ans[j] = num;
                    j++;
                }
            }
        }
        return ans;
    }
}
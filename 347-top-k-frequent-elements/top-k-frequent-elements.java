class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int[] ans = new int[k];
        int i=0;
        Iterable<Map.Entry<Integer, Integer>> iterable = () -> map.entrySet().stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            .iterator();

        for (Map.Entry<Integer, Integer> entry : iterable) {
            if(i>k-1){
                break;
            }
            ans[i] = entry.getKey();
            i++;
        }
            
        return ans;
    }
}
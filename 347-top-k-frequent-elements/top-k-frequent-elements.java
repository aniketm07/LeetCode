class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> hm = new HashMap<>();
        
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        
        List<int[]> temp = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            temp.add(new int[]{entry.getValue(), entry.getKey()});
        }
        
        Collections.sort(temp, (a, b) -> b[0] - a[0]);
        
        for (int i = 0; i < k; i++) {
            ans[i] = temp.get(i)[1];
        }
        
        return ans;
    }
}
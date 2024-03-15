class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for(int i=0;i<n;i++){
            nums.add(i+1);
        }
        StringBuilder sb = new StringBuilder();
        k--;
        while(n>0){
            long fact = computeFactorial(n-1);
            int position = k/(int)fact;
            sb.append(nums.remove(position));
            k = k % (int)fact;
            n--;
        }
        return sb.toString();
    }

    public long computeFactorial(int n) {
        if (n == 0)
            return 1;
        else
            return n * computeFactorial(n - 1);
    }
}
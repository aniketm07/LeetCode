class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = 0;
        while(left<=right){
            int count = right-left;
            int currentCount = height[left]<height[right] ? height[left]*count : height[right]*count;
            max = currentCount > max ? currentCount : max;
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}
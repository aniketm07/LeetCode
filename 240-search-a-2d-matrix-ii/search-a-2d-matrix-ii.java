class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // ROWS
        for(int i=0; i<matrix.length; i++){
            if(matrix[i][0] <= target){
                int low = 0;
                int high = matrix[i].length-1;
                while(low<=high){
                    int mid = low + ((high - low) / 2);
                    if(matrix[i][mid]==target){
                        return true;
                    }else if(matrix[i][mid]<target){
                        low=mid+1;
                    }else{
                        high=mid-1;
                    }
                }
            }else{
               return false;
            }
        }
        return false;
    }
}
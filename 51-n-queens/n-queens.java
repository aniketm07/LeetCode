class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        nQueens(board, ans, 0, n);
        return ans;
    }

    public void nQueens(boolean[][] board, List<List<String>> ans, int col, int n){
        if(col == n){
            List<String> list = new ArrayList<>();
            for(int row=0;row<n;row++){
                StringBuilder sb = new StringBuilder();
                for(int column=0; column<n; column++){
                    if(board[row][column]){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            ans.add(list);
            return;
        }

        for(int row=0;row<n;row++){
            if(!checkClash(row, col, board, n)){
                board[row][col] = true;
                nQueens(board, ans, col+1, n);
                board[row][col] = false;
            }
        }
    }

    public Boolean checkClash(int row, int col, boolean[][] board, int n){
        // check for the row and column
        for(int i=0;i<=col;i++){
            if(board[row][i]){
                return true;
            }
        }
        // check for clash in upper left diagonal
        int i=row-1;
        int j=col-1;
        while(checkBounds(i, j, n)){
            if(board[i][j]){
                return true;
            }
            i--;j--;
        }
        // check for clash in bottom left diagonal
        i=row+1;
        j=col-1;
        while(checkBounds(i, j, n)){
            if(board[i][j]){
                return true;
            }
            i++;j--;
        }
        return false;
    }

    // check for bounds
    public boolean checkBounds(int i, int j, int n){
        return i>=0 && j>=0 && i<n && j<n;
    }
}
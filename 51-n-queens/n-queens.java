class Solution {

    boolean[] left;
    boolean[] upperLeft;
    boolean[] bottomLeft;

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        Arrays.stream(board).forEach(b -> Arrays.fill(b, '.'));
        left = new boolean[n];
        upperLeft = new boolean[2*n-1];
        bottomLeft = new boolean[2*n-1];
        nQueens(board, ans, 0, n);
        return ans;
    }

    public void nQueens(char[][] board, List<List<String>> ans, int col, int n){
        if(col == n){
            List<String> list = new ArrayList<>();
            for(int row=0;row<n;row++){
                StringBuilder sb = new StringBuilder();
                for(int column=0; column<n; column++){
                    sb.append(board[row][column]);
                }
                list.add(sb.toString());
            }
            ans.add(list);
            return;
        }

        for(int row=0;row<n;row++){
            if(!checkClash(row, col, n)){
                board[row][col] = 'Q';
                left[row] = true;
                bottomLeft[row+col] = true;
                upperLeft[n-1 + col-row] = true;
                nQueens(board, ans, col+1, n);
                left[row] = false;
                bottomLeft[row+col] = false;
                upperLeft[n-1 + col-row] = false;
                board[row][col] = '.';
            }
        }
    }

    public Boolean checkClash(int row, int col, int n){
        return left[row] || bottomLeft[row+col] || upperLeft[n-1 + col-row];
    }

    // check for bounds
    public boolean checkBounds(int i, int j, int n){
        return i>=0 && j>=0 && i<n && j<n;
    }
}
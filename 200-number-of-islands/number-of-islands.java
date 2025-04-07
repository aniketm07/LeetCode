class Solution {

    int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length) return;

        if(grid[i][j] == '1'){
            grid[i][j] = 'X';
            for(int[] dir : directions){
                dfs(grid, i + dir[0], j + dir[1]);
            }
        }
    }
}
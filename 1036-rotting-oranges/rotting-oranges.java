class Solution {
    public int orangesRotting(int[][] grid) {
        int countFresh = 0;
        Queue<Pair<int[], Integer>> queue = new LinkedList<>();
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==2){
                    int[] arr = {i, j};
                    queue.offer(new Pair(arr, 0));
                }
                if(grid[i][j]==1) countFresh++;
            }
        }
        
        return bfs(grid, queue, countFresh);
    }

    public int bfs(int[][] grid, Queue<Pair<int[], Integer>> queue, int countFresh){
        int n = grid.length;
        int m = grid[0].length;
        int made = 0;
        int timer = 0;

        while(!queue.isEmpty()){
            Pair<int[], Integer> pair = queue.poll();
            int row = pair.getKey()[0];
            int col = pair.getKey()[1];
            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            timer = pair.getValue();
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 1) {
                    grid[newRow][newCol] = 2;
                    int[] arr = {newRow, newCol};
                    queue.offer(new Pair(arr, timer+1));
                    made++;
                }
            }
        }

        if(made==countFresh) return timer;
        return -1;
    }
}
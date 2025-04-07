class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
                    queue.offer(new Pair(0,1));
                    visited[i][j] = true;
                    Pair<Integer, Integer> pair = queue.poll();
                    bfs(grid, visited, i, j, queue, n, m);
                    count++;
                }
            }
        }
        return count;
    }

    public void bfs(char[][] grid, boolean[][] visited, int i, int j, Queue<Pair<Integer, Integer>> queue, int n, int m){
        
        // TOP
        if(i-1>=0 && grid[i-1][j] == '1' && !visited[i-1][j]){
            visited[i-1][j] = true;
            queue.offer(new Pair(i-1,j));
        }
        // Bottom
        if(i+1<n && grid[i+1][j] == '1' && !visited[i+1][j]){
            visited[i+1][j] = true;
            queue.offer(new Pair(i+1,j));
        }
        // RIGHT
        if(j+1<m && grid[i][j+1] == '1' && !visited[i][j+1]){
            visited[i][j+1] = true;
            queue.offer(new Pair(i,j+1));
        }
        // LEFT
        if(j-1>=0 && grid[i][j-1] == '1' && !visited[i][j-1]){
            visited[i][j-1] = true;
            queue.offer(new Pair(i,j-1));
        }
        while(queue.size() > 0){
            Pair<Integer, Integer> pair = queue.poll();
            bfs(grid, visited, pair.getKey(), pair.getValue(), queue, n, m);
        }
    }

    // public void Print(boolean[][] array){
    //     for (boolean[] x : array) {
    //         for (boolean y : x){
    //             System.out.print(y + " ");
    //         }
    //         System.out.println();
    //     }
    // }
}
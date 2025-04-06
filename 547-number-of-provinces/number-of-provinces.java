class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        Boolean[] visited = new Boolean[n];
        Arrays.fill(visited, false);
        int count = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(isConnected, i, visited, n);
                count++;
            }
        }
        return count;
    }

    public void dfs(int[][] isConnected, int i, Boolean[] visited, int n){
        for(int j=0;j<n;j++){
            if(isConnected[i][j] == 1 && !visited[j]){
                visited[j] = true;
                dfs(isConnected, j, visited, n);
            }
        }
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color){
            return image;
        }
        int n = image.length;
        int m = image[0].length;
        int oldColor = image[sr][sc];
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair(sr, sc));
        image[sr][sc] = color;
        while(!queue.isEmpty()){
            Pair<Integer, Integer> pair = queue.poll();
            int row = pair.getKey();
            int col = pair.getValue();
            for(int rowDelta=-1;rowDelta<=1;rowDelta++){
                for(int colDelta=-1;colDelta<=1;colDelta++){
                    if (Math.abs(rowDelta) + Math.abs(colDelta) != 1) continue;
                    int nrow = row + rowDelta;
                    int ncol = col + colDelta;
                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                            && image[nrow][ncol] == oldColor) {
                        image[nrow][ncol] = color;
                        queue.offer(new Pair(nrow, ncol));
                    }
                }
            }
        }
        return image;
    }
}
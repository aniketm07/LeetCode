class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if (oldColor == color) return image;

        int n = image.length;
        int m = image[0].length;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up, Down, Left, Right

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = color;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m
                        && image[newRow][newCol] == oldColor) {
                    image[newRow][newCol] = color;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        return image;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int og = image[sr][sc];
        if(og != color) {
            dfs(image, sr, sc, og, color);
        }
        return image;
    }

    private void dfs(int[][] image, int r, int c, int ogColor, int newColor) {
        if(r < 0 || c < 0 || r >= image.length || c >= image[0].length || image[r][c] != ogColor) {
            return;
        }

        image[r][c] = newColor;

        dfs(image, r+1, c, ogColor, newColor);
        dfs(image, r-1, c, ogColor, newColor);
        dfs(image, r, c+1, ogColor, newColor);
        dfs(image, r, c-1, ogColor, newColor);
    }
}
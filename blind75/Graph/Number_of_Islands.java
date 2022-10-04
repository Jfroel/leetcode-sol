class Solution {
    boolean[][] visited;
    public int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                count += dfs(grid, x, y);
            }
        }
        return count++;
    }
    private int dfs(char[][] grid, int x, int y) {
        if (visited[y][x]) return 0;
        visited[y][x] = true;
        if (grid[y][x] == '0') return 0;
        
        if (x+1 < grid[0].length) dfs(grid, x+1, y);
        if (x-1 > -1) dfs(grid, x-1, y);
        if (y+1 < grid.length) dfs(grid, x, y+1);
        if (y-1 > -1) dfs(grid, x, y-1);
        return 1;
    }
}

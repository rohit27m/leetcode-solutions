class Solution {
    public int numIslands(char[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;
        int count = 0;

        for (int row = 0; row < nr; row++) {
            for (int column = 0; column < nc; column++) {
                if (grid[row][column] == '1') {
                    count++;
                    dfs(grid, row, column);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int row, int column) {
        if (row < 0 || column < 0 || row >= grid.length || column >= grid[0].length || grid[row][column] == '0') {
            return;
        }

        grid[row][column] = '0';

        dfs(grid, row + 1, column);
        dfs(grid, row - 1, column);
        dfs(grid, row, column + 1);
        dfs(grid, row, column - 1);
    }
}

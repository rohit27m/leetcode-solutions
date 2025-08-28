class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        for (int i = 0; i < n; i++) {
            sortDiagonal(grid, i, 0, true);
        }

        for (int j = 1; j < n; j++) {
            sortDiagonal(grid, 0, j, false);
        }

        return grid;
    }

    private void sortDiagonal(int[][] grid, int row, int col, boolean descending) {
        int n = grid.length;
        int size = 0;
        int[] temp = new int[n];
        int r = row, c = col;

        while (r < n && c < n) {
            temp[size++] = grid[r][c];
            r++;
            c++;
        }

        for (int a = 0; a < size; a++) {
            for (int b = a + 1; b < size; b++) {
                if ((descending && temp[a] < temp[b]) || (!descending && temp[a] > temp[b])) {
                    int t = temp[a];
                    temp[a] = temp[b];
                    temp[b] = t;
                }
            }
        }

        r = row;
        c = col;
        int idx = 0;
        while (r < n && c < n) {
            grid[r][c] = temp[idx++];
            r++;
            c++;
        }
    }
}

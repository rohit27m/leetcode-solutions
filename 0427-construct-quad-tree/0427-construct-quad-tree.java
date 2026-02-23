class Solution {
    public Node construct(int[][] grid) {
        return divide(grid, 0, 0, grid.length);
    }
    private Node divide(int[][] grid, int row, int col, int size) {
        boolean same = true;
        int first = grid[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (grid[i][j] != first) {
                    same = false;
                    break;
                }
            }
            if (!same) break;
        }
        if (same) {
            return new Node(first == 1, true);
        }
        int half = size / 2;
        Node topLeft = divide(grid, row, col, half);
        Node topRight = divide(grid, row, col + half, half);
        Node bottomLeft = divide(grid, row + half, col, half);
        Node bottomRight = divide(grid, row + half, col + half, half);
        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}
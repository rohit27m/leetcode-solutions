class Solution {

    public Node construct(int[][] grid) {
        int n = grid.length;
        return divide(grid, 0, 0, n);
    }

    private Node divide(int[][] grid, int row, int col, int size) {

        // Check if all values in this square are same
        boolean isSame = true;
        int firstVal = grid[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (grid[i][j] != firstVal) {
                    isSame = false;
                    break;
                }
            }
            if (!isSame) break;
        }

        // If all values same → Leaf node
        if (isSame) {
            return new Node(firstVal == 1, true);
        }

        // Otherwise divide into 4 parts
        int half = size / 2;

        Node topLeft = divide(grid, row, col, half);
        Node topRight = divide(grid, row, col + half, half);
        Node bottomLeft = divide(grid, row + half, col, half);
        Node bottomRight = divide(grid, row + half, col + half, half);

        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}
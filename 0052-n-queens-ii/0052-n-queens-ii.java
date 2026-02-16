class Solution {
    public int totalNQueens(int n) {
        return solve(0, 0, 0, 0, n);
    }

    private int solve(int row, int cols, int d1, int d2, int n) {
        if (row == n) return 1;

        int count = 0;
        int available = ((1 << n) - 1) & ~(cols | d1 | d2);

        while (available != 0) {
            int pos = available & -available; // rightmost 1
            available -= pos;

            count += solve(row + 1,
                    cols | pos,
                    (d1 | pos) << 1,
                    (d2 | pos) >> 1,
                    n);
        }
        return count;
    }
}

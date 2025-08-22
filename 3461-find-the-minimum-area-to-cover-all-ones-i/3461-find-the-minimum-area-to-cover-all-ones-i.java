class Solution {
    public int minimumArea(int[][] grid) {
        int row = grid.length;
        int cols=grid[0].length;
        int minrow = row, maxrow = -1;
        int mincols = cols, maxcols = -1;
        for(int i=0;i<row;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                    minrow = Math.min(minrow,i);
                    maxrow = Math.max(maxrow,i);
                    mincols=Math.min(mincols,j);
                    maxcols=Math.max(maxcols,j);
                }
            }
        }
        int h= maxrow - minrow +1;
        int b = maxcols - mincols +1;
        return h*b;
    }
}
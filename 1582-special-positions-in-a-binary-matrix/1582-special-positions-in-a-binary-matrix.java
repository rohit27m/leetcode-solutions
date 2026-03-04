class Solution {
    public int numSpecial(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[] rows = new int[row];
        int[] cols = new int[col];
        int count =0;
        for(int i = 0; i< row; i++){
            for(int j = 0; j< col; j++){
                if(mat[i][j] == 1 ){
                    rows[i]++;
                    cols[j]++;
                }
            }
        }
        for(int i = 0; i< row; i++){
            for(int j = 0; j<col; j++){
                if(mat[i][j]==1 && rows[i] == 1 && cols[j]==1){
                    count++;
                }
            }
        }
        return count;
    }
}
class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;
        for(int i = 1; i<m ; i++){
            for(int j = 0; j<n; j++){
                if(matrix[i][j]!= 0){
                    matrix[i][j]+= matrix[i-1][j];
                }
            }
        }
        for(int i = 0; i<m; i++){
            int[] rows = matrix[i].clone();
            Arrays.sort(rows);
            for(int j = n -1; j>=0; j--){
                int height = rows[j];
                int width = n - j;
                ans = Math.max(ans , height*width);
            }
        }
        return ans;
    }
}
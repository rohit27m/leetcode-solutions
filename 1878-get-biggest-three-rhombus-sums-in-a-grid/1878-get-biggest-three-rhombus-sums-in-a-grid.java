class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        TreeSet<Integer> set = new TreeSet<>();
        for(int r = 0; r<m; r++){
            for(int c = 0; c<n; c++){
                addToset(set, grid[r][c]);
                for(int k = 1; r-k>=0 && r+k<m && c - k >=0 && c+k <n ;k++){
                    int sum = 0;
                    for(int i = 0; i< k; i++){
                        sum += grid[r-k+i][c+i];
                    }
                    for(int i = 0; i< k; i++){
                        sum += grid[r+i][c+k-i];
                    }
                    for(int i = 0; i < k; i++){
                        sum += grid[r+k-i][c-i];
                    }
                    for(int i = 0; i< k; i++){
                        sum += grid[r-i][c-k+i];
                    }
                    addToset(set , sum);
                }
            }
        }
        int[] res = new int[set.size()];
        int idx = 0;
        for(int ele : set.descendingSet()){
            res[idx++] = ele;
        }
        return res;
    }
    public void addToset(TreeSet<Integer> set, int sum){
        set.add(sum);
        if(set.size() > 3){
            set.pollFirst();
        }
    }
}
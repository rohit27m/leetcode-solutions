class Solution {
    public int[] rearrangeArray(int[] nums) {
        int pidx =0;
        int nidx = 1;
        int len = nums.length;
        int[] ass = new int[len];
        for(int r: nums){
            if(r>=0){
                ass[pidx] = r;
                pidx+=2;
            }else{
                ass[nidx] =r;
                nidx+=2;
            }
        }
        return ass;
    }
}
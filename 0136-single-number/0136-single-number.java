class Solution {
    public int singleNumber(int[] nums) {
        int count =0;
        for(int num:nums){
            count ^=num;
        }
        return count;
    }
}
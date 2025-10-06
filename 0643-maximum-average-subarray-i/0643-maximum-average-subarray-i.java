class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        double currSum =0;
        for(int i =0; i< k ; i++){
            currSum += nums[i];

        }
        double mxSum = currSum;
        for(int right = k; right <nums.length; right++){
            currSum += nums[right];
            currSum -= nums[left];
            left++;
            mxSum = Math.max(mxSum, currSum);
        }
        return mxSum/k;
    }
}
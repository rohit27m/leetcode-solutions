class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalgas = 0;
        int totalcost = 0;
        for(int i = 0; i< gas.length; i++){
            totalgas += gas[i];
            totalcost += cost[i];
            
        }
        if(totalgas < totalcost){
                return -1;
        }
        int curr = 0;
        int start =0;
        for(int i = 0; i< gas.length; i++){
            curr += gas[i] - cost[i];
            if(curr < 0){
                start = i+1;
                curr = 0;

            }
        }
        return start;
    }
}
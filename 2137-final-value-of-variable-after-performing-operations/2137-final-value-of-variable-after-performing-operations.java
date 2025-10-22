class Solution {
    public int finalValueAfterOperations(String[] op) {
        int count =0;
        for(String s: op){
            if(s.charAt(1)=='+'){
                count++;
            }else{
                count--;
            }
        }
        return count;
    }
}
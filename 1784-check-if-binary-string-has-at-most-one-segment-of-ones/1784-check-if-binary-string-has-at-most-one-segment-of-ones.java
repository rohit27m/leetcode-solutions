class Solution {
    public boolean checkOnesSegment(String s) {
        boolean zero = false;
        for(int i =0; i<s.length(); i++){
            if(s.charAt(i) == '0' && s.charAt(i-1)== '1'){
                zero = true;
            }
            if(zero && s.charAt(i) == '1' ){
                return false;
            }
        }
        return true;
    }
}
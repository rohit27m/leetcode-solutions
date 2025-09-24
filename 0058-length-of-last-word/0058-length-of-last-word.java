class Solution {
    public int lengthOfLastWord(String s) {
        int count =0;
        String newS = s.trim();
        for(int i = newS.length() - 1; i>=0; i--){
            if(newS.charAt(i)!=' '){
                count++;
            }else{
                break;
            }

        }
        return count;
    }
}
class Solution {
    public char findTheDifference(String s, String t) {
        int res = 0 ;
        String st = s+t;

        for(int i = 0; i<st.length(); i++){
            res^= st.charAt(i);

        }
        return (char)res;
    }
}
class Solution {
    public boolean isValid(String word) {
        if(word.length() <3) return false;
        boolean flag_vow=false;
        boolean flag_con=false;
        String vow  = "aeiouAEIOU";
        for(int i = 0; i<word.length();i++){
            char ch= word.charAt(i);
            if(!Character.isLetterOrDigit(ch)){
                return false;
            }else if(vow.indexOf(ch)!=-1){
                flag_vow = true;
            }else if(Character.isLetter(ch)){
                flag_con =true;
            }
        }
        return flag_vow && flag_con;
    }
}
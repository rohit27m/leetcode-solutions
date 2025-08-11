class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> dict= new HashMap();
        int count = 0;
        for(Character ch : s.toCharArray()){
            if(!dict.containsKey(ch)){
                dict.put(ch,1);
            }else{
                dict.put(ch, dict.get(ch)+1);
                if(dict.get(ch)%2==0){
                    count +=2;
                }
            }
        }
        return (count ==s.length()) ? count: count+1;
    }
}
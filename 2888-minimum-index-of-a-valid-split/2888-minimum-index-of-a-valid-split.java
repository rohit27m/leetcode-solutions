class Solution {
    public int minimumIndex(List<Integer> nums) {
       Map<Integer, Integer> dict = new HashMap<>(); 
       Map<Integer, Integer> dicts= new HashMap<>();
       for (int num :nums){
        dicts.put(num, dicts.getOrDefault(num,0)+1);
       }
       int n=nums.size();
       for(int i =0; i<n; i++){
        int num = nums.get(i);
        dict.put(num, dict.getOrDefault(num,0)+1);
        dicts.put(num, dicts.get(num)-1);
        if((dict.get(num)*2>(i+1) && dicts.get(num)*2 >(n-1-i))){
            return i;
        }
        }
        return -1;
    }
}
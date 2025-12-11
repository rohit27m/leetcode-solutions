class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String,Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        if(s.length()<10){
            return list;
        }
        StringBuilder sb = new StringBuilder(s.substring(0,10));
        map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);

        int l =0;
        for(int i=10;i<s.length();i++){
            sb.deleteCharAt(l);
            sb.append(s.charAt(i));
            map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);

        }
        System.out.println(map);
        for(String i:map.keySet()){
            if(map.get(i)>1){
                list.add(i);
            }
        }
        return list;
    }
}
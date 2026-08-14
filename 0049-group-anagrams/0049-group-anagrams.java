class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> mp=new HashMap<>();
        for(String str: strs){
            char[] arr=str.toCharArray();
            Arrays.sort(arr);
            String temp=new String(arr);
            List<String> li=mp.get(temp);
            if(li==null) mp.put(temp,new ArrayList<>());
            mp.get(temp).add(str);
        }
        List<List<String>> ans=new ArrayList<>();
        for(Map.Entry<String,List<String>> e: mp.entrySet()){
            ans.add(e.getValue());
        }
        return ans;
    }
}
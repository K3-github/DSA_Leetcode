class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder,(a,b)-> a.length() - b.length());
        HashMap<String,Boolean> mp=new HashMap<>();
        List<String> ans=new ArrayList<>();
        for(String str: folder){
            List<String> list = Arrays.asList(str.split("/"));
            Boolean need=true;
            StringBuilder temp=new StringBuilder();
            int n=list.size();
            for(int i=1;i<n;i++){
                temp.append(list.get(i));
                if(mp.containsKey(temp.toString())){
                       need=false;
                       break;
                }
                if(i<n-1) temp.append('+');
            }
            if(need){
                ans.add(str);
                mp.put(temp.toString(),true);
            }
        }
        return ans;
    }
}
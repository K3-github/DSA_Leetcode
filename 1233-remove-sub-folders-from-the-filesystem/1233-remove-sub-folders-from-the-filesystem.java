class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder,(a,b)-> a.length() - b.length());
        HashSet<String> st=new HashSet<>();
        List<String> ans=new ArrayList<>();
        for(String str: folder){
            List<String> list = Arrays.asList(str.split("/"));
            boolean need=true;
            StringBuilder temp=new StringBuilder();
            int n=list.size();
            for(int i=1;i<n;i++){
                temp.append(list.get(i));
                if(st.contains(temp.toString())){
                       need=false;
                       break;
                }
                if(i<n-1) temp.append('+');
            }
            if(need){
                ans.add(str);
                st.add(temp.toString());
            }
        }
        return ans;
    }
}
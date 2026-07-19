class Solution {
    private int solve(int node,List<List<Integer>> g,boolean[] vis){
        vis[node]=true;

        int ans=26;
        for(Integer adjNode: g.get(node)){
            if(!vis[adjNode]){
                ans=Math.min(ans,solve(adjNode,g,vis));
            }
        }
        return Math.min(ans,node);
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        List<List<Integer>> g=new ArrayList<>();
        for(int i=0;i<26;i++){
            g.add(new ArrayList<>());
        }
        for(int i=0;i<s1.length();i++){
            int u=s1.charAt(i)-'a';
            int v=s2.charAt(i)-'a';
            g.get(u).add(v);
            g.get(v).add(u);
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<baseStr.length();i++){
            char ch=baseStr.charAt(i);
            boolean[] vis=new boolean[26];
            int mnChar=solve(ch-'a',g,vis);
            if(mnChar<(ch-'a')){
                sb.append((char)(mnChar+'a'));
            }
            else sb.append(ch);
        }
        return sb.toString();
    }
}
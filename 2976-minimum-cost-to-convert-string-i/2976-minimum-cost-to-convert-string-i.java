class Solution {
    int[][] minCost;
    private void findShortestCost(char[] original,char[] changed, int[] cost){
        minCost=new int[26][26];
        for(int i=0;i<26;i++){
            Arrays.fill(minCost[i],Integer.MAX_VALUE);
        }
        for(int i=0;i<original.length;i++){
            int u=original[i]-'a';
            int v=changed[i]-'a';
            minCost[u][v]=Math.min(minCost[u][v],cost[i]);
        }
        for(int i=0;i<26;i++) minCost[i][i]=0;

        for(int via=0;via<26;via++){
            for(int i=0;i<26;i++){
                for(int j=0;j<26;j++){
                    if(minCost[i][via]!=Integer.MAX_VALUE && minCost[via][j]!=Integer.MAX_VALUE){
                        minCost[i][j]=Math.min(minCost[i][j],minCost[i][via]+minCost[via][j]);
                    }
                }
            }
        }

    }
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        findShortestCost(original,changed,cost);
        long ans=0;
        for(int i=0;i<source.length();i++){
            int u=source.charAt(i)-'a';
            int v=target.charAt(i)-'a';
            if(minCost[u][v]==Integer.MAX_VALUE) return -1;
            ans=ans+(long)minCost[u][v];
        }
        return ans;
    }
}
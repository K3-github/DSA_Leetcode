class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int[] cost=new int[26];
        for(int i=0;i<26;i++) cost[i]=i+1;
        for(int i=0;i<chars.length();i++) cost[chars.charAt(i)-'a']=vals[i];

        int curr=0;
        int ans=0;
        for(char ch:s.toCharArray()){
            int val=cost[ch-'a'];
            curr+=val;
            ans=Math.max(ans,curr);
            if(curr<0) curr=0;
        }
        return ans;
    }
}
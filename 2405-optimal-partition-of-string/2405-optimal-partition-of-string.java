class Solution {
    public int partitionString(String s) {
        boolean[] seen=new boolean[26];
        int n=s.length();
        int ans=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(seen[ch-'a']){
                ans++;
                Arrays.fill(seen,false);
            }
            seen[ch-'a']=true;
        }
        return ans+1;
    }
}
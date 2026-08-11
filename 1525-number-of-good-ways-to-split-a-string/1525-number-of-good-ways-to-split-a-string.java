class Solution {
    public int numSplits(String s) {
        int[] tf=new int[26];
        int n=s.length();
        int td=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            tf[ch-'a']++;
            if(tf[ch-'a']==1) td++;
        }
        int[] lf=new int[26];
        int ld=0;
        int ans=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            lf[ch-'a']++;
            if(lf[ch-'a']==1) ld++;

            tf[ch-'a']--;
            if(tf[ch-'a']==0) td--;

            if(ld==td) ans++;
        }
        return ans;
    }
}
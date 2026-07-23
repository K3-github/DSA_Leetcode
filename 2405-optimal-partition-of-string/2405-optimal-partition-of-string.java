class Solution {
    public int partitionString(String s) {
        int mask=0;
        int n=s.length();
        int ans=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            int bit=1<<(ch-'a');
            if((mask & bit)!=0){
                ans++;
                mask=0;
            }
            mask|=bit;
        }
        return ans+1;
    }
}
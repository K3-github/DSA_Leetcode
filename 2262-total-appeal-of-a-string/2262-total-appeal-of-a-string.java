class Solution {
    public long appealSum(String s) {
        int n=s.length();
        int[] last=new int[26];
        Arrays.fill(last,-1);

        long ans=0,curr=0;
        for(int i=0;i<n;i++){
            int ch=s.charAt(i)-'a';
            curr+=i-last[ch];
            ans+=curr;
            last[ch]=i;
        }
        return ans;
    }
}
class Solution {
    public List<Integer> partitionLabels(String s) {
        int n=s.length();
        int[] lastIndex=new int[26];
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            lastIndex[ch-'a']=i;
        }
        int left=0;
        int mxReach=0;
        List<Integer> ans=new ArrayList<>();
        for(int right=0;right<n;right++){
            char ch=s.charAt(right);
            mxReach=Math.max(mxReach,lastIndex[ch-'a']);
            if(right==mxReach){
               ans.add(right-left+1);
               left=right+1;
            }
        }
        return ans;
    }
}
class Solution {
    private boolean isValid(String curr){
        int[] f=new int[26];
        for(char ch: curr.toCharArray()){
            if(f[ch-'a']>0) return false;
            f[ch-'a']++;
        }
        return true;
    }
    private int solve(int ind,int n,String curr,List<String> arr){
        if(ind==n){
            if(isValid(curr)==true) return curr.length();
            return 0;
        }
        int len1=solve(ind+1,n,curr+arr.get(ind),arr);
        int len2=solve(ind+1,n,curr,arr);
        return Math.max(len1,len2);
    }
    public int maxLength(List<String> arr) {
        int n=arr.size();
        return solve(0,n,"",arr);
    }
}
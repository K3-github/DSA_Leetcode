class Solution {
    private boolean check(String str){
        int n=str.length();
        char f=str.charAt(0),l=str.charAt(n-1);
        if((f=='a' || f=='e' || f=='i' || f=='o' || f=='u') &&
        ((l=='a' || l=='e' || l=='i' || l=='o' || l=='u'))
        ) return true;
        return false;
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n=words.length;
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            if(check(words[i])==true){
                arr[i]=1;
            }
        }
        int[] psum=new int[n+1];
        for(int i=0;i<n;i++){
            psum[i+1]=psum[i]+arr[i];
        }
        int len=queries.length;
        int[] ans=new int[len];
        for(int i=0;i<len;i++){
            int l=queries[i][0],r=queries[i][1];
            ans[i]=psum[r+1]-psum[l];
        }
        return ans;
    }
}
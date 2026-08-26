class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n=s.length();

        int left=0,right=0;
        int minLen=n+1;
        String ans="";
        while(right<n){
            char rightCh=s.charAt(right);
            if(rightCh=='1') k--;
            while(left<=right && k==0){
                int currLen=right-left+1;
                String sub=s.substring(left,left+currLen);
                if(currLen<minLen || (currLen==minLen && ans.compareTo(sub)>0)){
                    minLen=currLen;
                    ans=sub;
                }
                char leftCh=s.charAt(left);
                if(leftCh=='1') k++;
                left++;
            }
            right++;
        }
        return ans;
    }
}
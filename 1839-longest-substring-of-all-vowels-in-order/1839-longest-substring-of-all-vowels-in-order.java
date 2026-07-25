class Solution {
    private int getOrder(char ch){
        if(ch=='a') return 0;
        if(ch=='e') return 1;
        if(ch=='i') return 2;
        if(ch=='o') return 3;
        return 4;
    }
    public int longestBeautifulSubstring(String word) {
        int left=0,right=0;
        int ans=0;
        int n=word.length();
        while(right<n){
            while(left<n && word.charAt(left)!='a'){
                left++;
            }
            if(left==n) return ans;
            right=left+1;
            char prev=word.charAt(left);
            int distinct = 1;
            while(right<n){
                char next=word.charAt(right);
                int prevOrder = getOrder(prev);
                int nextOrder = getOrder(next);
                if(nextOrder==prevOrder || nextOrder==prevOrder+1){
                    prev=next;right++;
                }
                else break;
                if(nextOrder==prevOrder+1) distinct++;
                if(distinct==5){
                    ans=Math.max(ans,right-left);
                }
            }
            left=right;
        }
        return ans;
    }
}
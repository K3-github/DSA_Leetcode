class Solution {
    private int getOrder(char ch){
        if(ch=='a') return 0;
        if(ch=='e') return 1;
        if(ch=='i') return 2;
        if(ch=='o') return 3;
        return 4;
    }
    public int longestBeautifulSubstring(String word) {
        HashMap<Character,Integer> mp=new HashMap<>();
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
            mp.put(prev,mp.getOrDefault(prev,0)+1);
            while(right<n){
                char next=word.charAt(right);
                int prevOrder = getOrder(prev);
                int nextOrder = getOrder(next);
                if(nextOrder==prevOrder || nextOrder==prevOrder+1){
                    prev=next;right++;
                }
                else break;
                mp.put(next,mp.getOrDefault(next,0)+1);
                if(mp.size()==5){
                    ans=Math.max(ans,right-left);
                }
            }
            left=right;
            mp.clear();
        }
        return ans;
    }
}
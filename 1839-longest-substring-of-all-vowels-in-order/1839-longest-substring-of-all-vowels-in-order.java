class Solution {
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
                if(prev=='a' && (next=='a' || next=='e')){
                    prev=next;
                    right++;
                }
                else if(prev=='e' && (next=='e' || next=='i')){
                    prev=next;
                    right++;
                }
                else if(prev=='i' && (next=='i' || next=='o')){
                    prev=next;
                    right++;
                }
                else if(prev=='o' && (next=='o' || next=='u')){
                    prev=next;
                    right++;
                }
                else if(prev=='u' && next=='u'){
                    prev=next;
                    right++;
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
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> mp=new HashMap<>();
        int n=s1.length(),m=s2.length();
        for(int i=0;i<n;i++){
            char ch=s1.charAt(i);
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        int left=0,right=0;
        int count=mp.size();
        while(right<m){
             char ch=s2.charAt(right);
             if(mp.containsKey(ch)){
                mp.put(ch,mp.get(ch)-1);
                if(mp.get(ch)==0) count--;
             }
             if(right-left+1<n){
                right++;
             }
             else if(right-left+1==n){
                 if(count==0) return true;
                 ch=s2.charAt(left);
                 if(mp.containsKey(ch)){
                    if(mp.get(ch)==0) count++;
                    mp.put(ch,mp.get(ch)+1);
                 }
                 left++;right++;
             }
        }
        return false;
    }
}
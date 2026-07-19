class Solution {
    public String smallestSubsequence(String s) {
        int[] lastIndex=new int[26];
        int n=s.length();
        for(int i=0;i<n;i++){
             char ch=s.charAt(i);
             lastIndex[ch-'a']=i;
        }
        boolean[] vis=new boolean[26];
        Stack<Character> st=new Stack<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(vis[ch-'a']) continue;
            while(st.size()>0 && st.peek()>=ch && lastIndex[st.peek()-'a']>i){
                    vis[st.peek()-'a']=false;
                    st.pop();
            }
            st.push(ch);
            vis[ch-'a']=true;
        }
        StringBuilder ans=new StringBuilder();
        while(st.size()>0){
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
}
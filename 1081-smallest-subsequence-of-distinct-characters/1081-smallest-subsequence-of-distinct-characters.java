class Solution {
    public String smallestSubsequence(String s) {
        int[] f=new int[26];
        for(char ch: s.toCharArray()) f[ch-'a']++;
        Stack<Character> st=new Stack<>();
        int[] seen=new int[26];
        for(char ch: s.toCharArray()){
            f[ch-'a']--;
            if(seen[ch-'a']==1) continue;
            while(st.size()>0 && st.peek()>ch && f[st.peek()-'a']>0){
                seen[st.pop()-'a']=0;
            }
            st.push(ch);
            seen[ch-'a']=1;
        }
        StringBuilder res=new StringBuilder();
        while(st.size()>0){
            res.append(st.pop());
        }
        return res.reverse().toString();
    }
}
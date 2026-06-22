class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder str=new StringBuilder(s);
        Stack<Integer> st=new Stack<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=str.charAt(i);
            if(ch=='(') st.push(i);
            else if(ch==')'){
                if(st.size()==0){
                    str.setCharAt(i,'#');
                    continue;
                }
                st.pop();
            }
        }
        while(st.size()>0){
            str.setCharAt(st.pop(),'#');
        }
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<n;i++){
            char ch=str.charAt(i);
            if(ch!='#') ans.append(ch);
        }
        return ans.toString();
    }
}
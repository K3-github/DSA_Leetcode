class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st=new Stack<>();
        for(char ch: num.toCharArray()){
            while(st.size()>0 && st.peek()>ch && k>0){
                st.pop();
                k--;
            }
            if(ch=='0'){
                if(st.size()>0) st.push(ch);
            }
            else st.push(ch);
        }
        while(st.size()>0 && k>0){
            st.pop(); k--;
        }
        char[] res=new char[st.size()];
        if(st.size()==0) return "0";
        int i=st.size()-1;
        while(st.size()>0){
            res[i--]=st.pop();
        }
        return new String(res);
    }
}
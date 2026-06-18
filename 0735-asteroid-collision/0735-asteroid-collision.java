class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n=asteroids.length;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            int as=asteroids[i];
            if(as>0) st.push(as);
            else{
                if(st.size()==0 || st.peek()<0) st.push(as);
                else{
                    while(st.size()>0 && st.peek()>0 && st.peek()<Math.abs(as)){
                        st.pop();
                    }
                    if(st.size()==0 || st.peek()<0) st.push(as);
                    else{
                        if(st.peek()==Math.abs(as)) st.pop();
                    }
                }
            }
        }
        int[] ans=new int[st.size()];
        int i=st.size()-1;
        while(st.size()>0){
            ans[i--]=st.pop();
        }
        return ans;
    }
}
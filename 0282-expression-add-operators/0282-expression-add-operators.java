class Solution {
    List<String> ans=new ArrayList<>();
    private boolean isValid(String curr,int target){
        Stack<String> st=new Stack<>();
        int n=curr.length();
        for(int i=0;i<n;i++){
            StringBuilder num=new StringBuilder();
            while(i<n && Character.isDigit(curr.charAt(i))){
                num.append(curr.charAt(i));
                i++;
            }
            if(i<n && curr.charAt(i)=='*'){
                long val=Long.parseLong(num.toString());
                while(i<n && curr.charAt(i)=='*'){
                    i++;
                    StringBuilder next=new StringBuilder();
                    while(i<n && Character.isDigit(curr.charAt(i))){
                        next.append(curr.charAt(i));
                        i++;
                    }
                    val*=Long.parseLong(next.toString());
                }
                st.push(String.valueOf(val));
            }
            else{
                st.push(num.toString());
            }
            if(i<n){
                st.push(String.valueOf(curr.charAt(i)));
            }
        }
        long res=Long.parseLong(st.pop());
        while(!st.isEmpty()){
            String sign=st.pop();
            long num=Long.parseLong(st.pop());
            if(sign.equals("+")){
                res=num+res;
            }
            else if(sign.equals("-")){
                res=num-res;
            }
        }
        return res==target;
    }
    private void solve(int ind,String curr,long value,long prev,int target,String num){
        if(ind==num.length()){
            if(value==target){
                ans.add(curr);
            }
            return;
        }

        for(int i=ind;i<num.length();i++){
            if(i>ind && num.charAt(ind)=='0'){
                break;
            }

            String part=num.substring(ind,i+1);
            long val=Long.parseLong(part);

            if(ind==0){
                solve(i+1,part,val,val,target,num);
            }
            else{
                solve(i+1,curr+"+"+part,value+val,val,target,num);
                solve(i+1,curr+"-"+part,value-val,-val,target,num);
                solve(i+1,curr+"*"+part,value-prev+prev*val,prev*val,target,num);
            }
        }
    }

    public List<String> addOperators(String num,int target){
        solve(0,"",0,0,target,num);
        return ans;
    }
}
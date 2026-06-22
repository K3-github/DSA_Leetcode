class Solution {
    List<String> ans=new ArrayList<>();
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
class Solution {
    List<String> ans=new ArrayList<>();
    private boolean valid(String str){
        if(str.length()==0 || str.length()>3){
            return false;
        }
        if(str.length()>1 && str.charAt(0)=='0'){
            return false;
        }
        return Integer.parseInt(str)<=255;
    }

    private void solve(int ind,String s,StringBuilder temp,int parts){
        if(parts==0){
            if(ind==s.length()){
                ans.add(temp.substring(0,temp.length()-1));
            }
            return;
        }
        for(int i=ind;i<s.length();i++){
            String part=s.substring(ind,i+1);
            if(valid(part)){
                temp.append(part);
                temp.append('.');
                solve(i+1,s,temp,parts-1);
                temp.delete(temp.length()-part.length()-1,temp.length());
            }
        }
    }
    public List<String> restoreIpAddresses(String s){
        solve(0,s,new StringBuilder(),4);
        return ans;
    }
}
class Solution {
    public boolean checkValidString(String s) {
        int cnt=0;
        int stars=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='(') cnt++;
            else if(ch==')'){
                if(cnt>0) cnt--;
                else{
                    if(stars==0) return false;
                    stars--;
                }
            }
            else stars++;
        }
        if(cnt>stars) return false;
        cnt=0;stars=0;
        for(int i=n-1;i>=0;i--){
            char ch=s.charAt(i);
            if(ch==')') cnt++;
            else if(ch=='('){
                if(cnt>0) cnt--;
                else{
                    if(stars==0) return false;
                    stars--;
                }
            }
            else stars++;
        }
        if(cnt>stars) return false;
        return true;
    }
}
// ((((****
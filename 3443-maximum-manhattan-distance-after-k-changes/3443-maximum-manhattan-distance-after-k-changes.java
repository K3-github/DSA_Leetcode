class Solution {
    public int maxDistance(String s, int k) {
        int ans=0;
        int[][] dir={{1,1},{1,-1},{-1,1},{-1,-1}};
        
        for(int[] d:dir){
            int curr=0;
            int changes=k;
            for(char ch:s.toCharArray()){
                int val=0;
                if(ch=='E') val=d[0];
                else if(ch=='W') val=-d[0];
                else if(ch=='N') val=d[1];
                else val=-d[1];
                
                if(val==-1 && changes>0){
                    curr+=1;
                    changes--;
                }
                else{
                    curr+=val;
                }
                ans=Math.max(ans,curr);
            }
        }
        return ans;
    }
}
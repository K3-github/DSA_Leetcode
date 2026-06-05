class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[] prev=new int[n];
        
        Arrays.fill(prev,10000000);
        
        prev[0]=triangle.get(0).get(0);
        for(int i=1;i<n;i++){
            int[] curr=new int[n];
            Arrays.fill(curr,10000000);
            for(int j=0;j<triangle.get(i).size();j++){
                  int left=10000000;
                  if(j>0) left=prev[j-1];
                  int right=prev[j];
                  curr[j]=triangle.get(i).get(j)+Math.min(left,right);
            }
            prev=curr;
        }
        int ans=10000000;
        for(int i=0;i<n;i++){
            ans=Math.min(ans,prev[i]);
        }
        return ans;
    }
}
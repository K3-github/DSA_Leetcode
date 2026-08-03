class Solution {
    HashMap<Integer,Boolean> dp=new HashMap<>();
    private boolean solve(int mask,int currTotal,int mx,int desiredTotal){
        if(dp.containsKey(mask)) return dp.get(mask);
        for(int num=1;num<=mx;num++){
            if((mask>>(num-1)&1) !=0) continue;
            if(currTotal+num>=desiredTotal){
                dp.put(mask,true);
                return true;
            }

            int newMask = 1<<(num-1) | mask;
            if(!solve(newMask,currTotal+num,mx,desiredTotal)){
                dp.put(mask,true);
                return true;
            }
        }
        dp.put(mask,false);
        return false;
    }
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal<=0) return true;

        int sum=maxChoosableInteger*(maxChoosableInteger+1)/2;
        if(sum<desiredTotal) return false;
        return solve(0,0,maxChoosableInteger,desiredTotal);
    }
}
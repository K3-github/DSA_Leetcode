class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n=aliceValues.length;
        Integer[] idx=new Integer[n];
        for(int i=0;i<n;i++){
            idx[i]=i;
        }
        Arrays.sort(idx, (i, j) ->
            (aliceValues[j] + bobValues[j]) - (aliceValues[i] + bobValues[i])
        );
        int aliceScore=0;
        int bobScore=0;
        for(int i=0;i<n;i++){
            if((i&1)==0) aliceScore+=aliceValues[idx[i]];
            else bobScore+=bobValues[idx[i]];
        }
        if(aliceScore>bobScore) return 1;
        if(aliceScore<bobScore) return -1;
        return 0;
    }
}
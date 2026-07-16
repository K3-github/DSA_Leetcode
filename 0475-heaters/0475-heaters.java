class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int j=0;
        int ans=0;
        for(int i=0;i<houses.length;i++){
            while(j+1<heaters.length &&
                  Math.abs(heaters[j+1]-houses[i])<=Math.abs(heaters[j]-houses[i])){
                j++;
            }
            ans=Math.max(ans,Math.abs(heaters[j]-houses[i]));
        }
        return ans;
    }
}
class Solution {
    private void solve(int room,List<List<Integer>> rooms,boolean[] vis){
        vis[room]=true;
        for(Integer childRoom: rooms.get(room)){
            if(!vis[childRoom]){
                solve(childRoom,rooms,vis);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[] vis=new boolean[n];
        solve(0,rooms,vis);
        for(int i=0;i<n;i++){
            if(!vis[i]) return false;
        }
        return true;
    }
}
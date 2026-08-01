class Solution {
    int index=0;
    private boolean solve(String[] pre){
        if(index>=pre.length) return false;
        if(pre[index].equals("#")){
            index++;
            return true;
        }
        index++;
        return solve(pre) && solve(pre);
    }
    public boolean isValidSerialization(String preorder) {
        String[] pre=preorder.split(",");
        return solve(pre) && index == pre.length;
    }
}
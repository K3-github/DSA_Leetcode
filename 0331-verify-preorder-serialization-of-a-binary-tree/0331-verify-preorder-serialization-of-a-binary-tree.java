class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] pre = preorder.split(",");
        int slots = 1;
        for (String node : pre) {
            slots--;
            if (slots < 0) return false;
            if (!node.equals("#")) slots += 2;
        }
        return slots == 0;
    }
}
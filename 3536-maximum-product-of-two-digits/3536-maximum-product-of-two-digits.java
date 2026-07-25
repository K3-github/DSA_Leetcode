class Solution {
    public int maxProduct(int n) {
        String str = String.valueOf(n);
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        int len=arr.length;
        return ((arr[len-1]-'0')*(arr[len-2]-'0'));
    }
}
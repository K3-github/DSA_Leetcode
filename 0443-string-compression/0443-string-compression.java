class Solution {
    public int compress(char[] chars) {
        int n=chars.length;
        int left=0,right=0;
        while(right<n){
            int count=1;
            while(right<n-1 && chars[right]==chars[right+1]){
                count++;right++;
            }
            chars[left]=chars[right];
            left++;right++;
            if(count==1) continue;
            String str=String.valueOf(count);
            for(char ch: str.toCharArray()){
                chars[left]=ch;
                left++;
            }
        }
        return left;
    }
}
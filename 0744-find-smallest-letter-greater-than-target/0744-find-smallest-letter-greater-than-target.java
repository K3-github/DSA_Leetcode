class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n=letters.length;
        int low=0,high=n-1;
        char ans=letters[0];
        while(low<=high){
            int mid=low+(high-low)/2;
            if(letters[mid]>target){
                ans=letters[mid];
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
}
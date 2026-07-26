class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats=0,n=people.length;
        int left=0,right=n-1;
        while(left<right){
            if(people[left]+people[right]<=limit){
                left++;right--;
            }
            else{
                right--;
            }
            boats++;
        }
        if(left==right) return 1+boats;
        return boats;
    }
}
// 1 2 2 3

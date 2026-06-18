class Solution {
    public int nextGreaterElement(int n) {
        if(n>=Integer.MAX_VALUE) return -1;
        int k=-1;
        List<Integer> arr=new ArrayList<>();
        while(n>0){
            arr.add(n%10);
            n/=10;
        }
        int sz=arr.size();
        for(int i=0;i<sz-1;i++){
            if(arr.get(i)>arr.get(i+1)){
                k=i+1;
                break;
            }
        }
        if(k==-1) return -1;
        for(int i=0;i<sz;i++){
            if(arr.get(i)>arr.get(k)){
                int tp=arr.get(i);
                arr.set(i,arr.get(k));
                arr.set(k,tp);
                Collections.reverse(arr.subList(0,k));
                break;
            }
        }
        long ans=0;
        for(int i=sz-1;i>=0;i--){
            ans=ans*10+arr.get(i);
        }
        if(ans>Integer.MAX_VALUE) return -1;
        return (int)ans;
    }
}
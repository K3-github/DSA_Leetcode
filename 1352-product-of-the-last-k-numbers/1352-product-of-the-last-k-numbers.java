class ProductOfNumbers {
    List<Integer> pp;

    public ProductOfNumbers() {
        pp=new ArrayList<>();
        pp.add(1);
    }

    public void add(int num) {
        if(num==0){
            pp.clear();
            pp.add(1);
        }
        else{
            pp.add(pp.get(pp.size()-1)*num);
        }
    }

    public int getProduct(int k) {
        if(k>=pp.size()) return 0;
        return pp.get(pp.size()-1)/pp.get(pp.size()-1-k);
    }
}
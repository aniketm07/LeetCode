class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> finalAns = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(i%3==0 && i%5==0){
                finalAns.add("FizzBuzz");
            }else if(i%3==0) {
                finalAns.add("Fizz");
            }else if(i%5==0) {
                finalAns.add("Buzz");
            }else{
                finalAns.add(Integer.toString(i));
            }
        }
        return finalAns;
    }
}
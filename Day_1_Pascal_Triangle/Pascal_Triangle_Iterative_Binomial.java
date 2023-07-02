public class Pascal_Triangle_Iterative_Binomial {
    public static void main(String[] args){
      int n =5;
      for(int i = 0; i < n ; i++){
          for( int j =0; j <= i; j++){
              System.out.print(binomial(i,j));
          }
          System.out.println();
      }
    }
    public static int binomial(int a, int b){
        return (factorial(a)/(factorial(a-b)* factorial(b)));
    }
    public static int factorial(int n){
        if(n==0){
            return 1;
        }
        return n*factorial(n-1);
    }

}

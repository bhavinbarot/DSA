package Math;

public class PrimeNumberCheck {
    public static void main(String args[]){

        int num= 16;
        System.out.println(isPrime(num));


    }

    public static boolean isPrime(int num){
        for(int i=2;i*i<num;i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}

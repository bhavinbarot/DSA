package Math;

public class SumofDigits {
    public static void main(String args[]){

        int num= 163;
        System.out.println(sumOfDigits(num));


    }

    public static int sumOfDigits(int num){
        int sum = 0;
        while(num > 0){
            int digit = num % 10;
            sum = sum + digit;
            num = num/10;
        }
        return sum;
    }
}

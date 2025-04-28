package Recursion;

public class Main {
    public static void main(String[] args){
        System.out.println(factorial(5));
    }
    public static int factorial(int n){
        if(n==1) return 1;
        int fact = 0;
        fact = n * factorial(n-1);
        n--;
        return fact;
    }
}

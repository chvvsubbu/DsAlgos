package dp;

public class Fibonacci {

    public static int fib(int n){
        int a = 0, b = 1, c;
        if(n == 0) return  0;
        for(int i = 2; i <= n; i++) {
            c = a+ b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci.fib(0));
        System.out.println(Fibonacci.fib(1));
        System.out.println(Fibonacci.fib(2));
        System.out.println(Fibonacci.fib(9));
    }
}

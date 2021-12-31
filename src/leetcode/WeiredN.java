package leetcode;

import java.util.Scanner;

public class WeiredN {

    public static void main(String[] args) {
        Long n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        n = sc.nextLong();

        while (true){
            System.out.print(n + ",");
            if(n  ==1) break;
            if(n >= Integer.MAX_VALUE){
                System.out.printf("corssed max "+ n);
            }
            if(n % 2 == 0 ) n = n/2;
            else n =  3* n + 1;
        }
        System.out.print( "\n");
    }
}

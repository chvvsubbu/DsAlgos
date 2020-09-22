package patterns.fastandslow;

public class HappyNumber {
    public static boolean find(int num){
        int slowPointer = findSquareSum(num);
        int fastPointer = findSquareSum(findSquareSum(num));
        do{
            slowPointer = findSquareSum(slowPointer);
            fastPointer = findSquareSum(findSquareSum(fastPointer));

        }while (slowPointer != fastPointer);
        return slowPointer ==1;
    }

    private static int findSquareSum(int num) {
        int sum = 0, dight;
        while (num > 0){
            dight = num % 10;
            sum += (dight * dight);
            num = num /10;
        }
        return sum;
    }

    public static void main(String[] args) {

        System.out.println(HappyNumber.find(23));
        System.out.println(HappyNumber.find(12));
    }
}

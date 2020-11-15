package dp;

public class CatalnNumber {

    public static int catalon(int n){
        if(n<=1) return  1;

        int res = 0;

        for (int i = 0; i < n; i++) {
            res += catalon(i)* catalon(n-i -1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(CatalnNumber.catalon(0));
        System.out.println(CatalnNumber.catalon(1));
        System.out.println(CatalnNumber.catalon(2));
        System.out.println(CatalnNumber.catalon(3));
        System.out.println(CatalnNumber.catalon(4));
    }
}

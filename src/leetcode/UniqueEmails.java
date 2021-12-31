package leetcode;

public class UniqueEmails {

    public int numUniqueEmails(String[] emails) {
        return 0;
    }

    public static void main(String[] args) {

        String str = "test.email+alex@leetcode.com";
        String[] strs = str.split("@");
        //System.out.println(str.contains("+"));
        System.out.println(strs[0]);
        str = "test.email+alex";
        System.out.println(str.split("\\+")[0]);

    }
}

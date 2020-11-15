package dp;

public class LCS {
    public int findLCSLength(String s1, String s2){
        return  findLCSLengthRecursively(s1, s2, 0, 0);
    }

    private int findLCSLengthRecursively(String s1, String s2, int i1, int i2) {

        if(i1 == s1.length() || i2 == s2.length()) return 0;
        if(s1.charAt(i1) == s2.charAt(i2)){
            return 1+ findLCSLengthRecursively(s1, s2, i1+1, i2+1);
        }

        int c1 = findLCSLengthRecursively(s1, s2, i1+1, i2);
        int c2 = findLCSLengthRecursively(s1, s2, i1, i2+1);
        return Math.max(c1, c2);
    }

    public int findLCSLengthTopDown(String s1, String s2){
        Integer[][] dp = new Integer[s1.length()][s2.length()];
        return  findLCSLengthRecursively(dp, s1, s2, 0, 0);
    }

    private int findLCSLengthRecursively(Integer[][] dp, String s1, String s2, int i1, int i2) {

        if(i1 == s1.length() || i2 == s2.length()) return 0;
        if(dp[i1][i2] == null){
            if(s1.charAt(i1) == s2.charAt(i2)){
                dp[i1][i2] = 1 + findLCSLengthRecursively(dp, s1, s2, i1+1, i2+1);
            }else {
                int c1 = findLCSLengthRecursively(dp, s1, s2, i1+1, i2);
                int c2 = findLCSLengthRecursively(dp, s1, s2, i1, i2+1);
                dp[i1][i2]= Math.max(c1, c2);
            }
        }

        return dp[i1][i2];
    }

    public int findLCSLengthBottomup(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        int maxLength = 0;
        for(int i = 1; i<= s1.length(); i ++){
            for(int j = 1; j<= s2.length(); j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {

        LCS lcs = new LCS();
        System.out.println( lcs.findLCSLength("abdca", "cbda"));
        System.out.println( lcs.findLCSLengthTopDown("abdca", "cbda"));
        System.out.println( lcs.findLCSLengthBottomup("abdca", "cbda"));
    }

}

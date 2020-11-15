package dp;

public class Tutorial1 {

    public static int lcs(char[] X,char[]Y,int m,int n) {
        if (m == 0 || n == 0)
            return 0;
        if (X[m-1] == Y[n-1])
            return 1 + lcs(X,Y,m-1,n-1);
        int len1 = lcs(X,Y,m-1,n);
        int len2 = lcs(X,Y,m,n-1);
        return Math.max(len1,len2);
    }

    public static int lcs2(char[] X, char[] Y,int m,int n) {
        if (m == X.length || n == Y.length)
            return 0;

        if (X[m] == Y[n])
            return 1 + lcs2(X,Y,m+1,n+1);

        int len1 = lcs2(X,Y,m+1,n);
        int len2 = lcs2(X,Y,m,n+1);
        return Math.max(len1,len2);
    }

    public static int lcs3(String X,String Y,int m,int n) {
        if (m == X.length() || n == Y.length())
            return 0;

        if (X.charAt(m) == Y.charAt(n))
            return 1 + lcs3(X,Y,m+1,n+1);
        return Math.max(lcs3(X,Y,m+1,n),lcs3(X,Y,m,n+1));
    }

    public static int topDown(String X,String Y,int m,int n,Integer[][] dp) {
        if (m == X.length() || n == Y.length())
            return 0;
        if (dp[m][n] == null) {
            if (X.charAt(m) == Y.charAt(n)) {
                dp[m][n] = 1 + topDown(X,Y,m+1,n+1,dp);
            }
            else {
                int len1 = topDown(X,Y,m,n+1,dp);
                int len2 = topDown(X,Y,m+1,n,dp);
                dp[m][n] = Math.max(len1,len2);
            }
        }
        return dp[m][n];
    }

    // m = X.length(), n = Y.length()
    public static int topDown2(String X,String Y,int m,int n,Integer[][] dp) {
        if (m == 0 || n == 0)
            return 0;

        if (dp[m][n] == null) {

            if (X.charAt(m-1) == Y.charAt(n-1)) {
                dp[m][n] = 1 + topDown2(X,Y,m-1,n-1,dp);
            }
            else {
                int len1 = topDown2(X,Y,m-1,n,dp);
                int len2 = topDown2(X,Y,m,n-1,dp);
                dp[m][n] = Math.max(len1,len2);
            }
        }
        return dp[m][n];
    }

    public static int bottomUp(String X,String Y) {

        int[][] dp = new int[X.length()+1][Y.length()+1];

        for (int i = 1; i <= X.length(); i++) {
            for (int j = 1; j <= Y.length(); j++) {

                if (X.charAt(i-1) == Y.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[X.length()][Y.length()];
    }

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        // int len = lcs2(s1.toCharArray(),s2.toCharArray(),s1.length(),s2.length());
        //int len2 = dp(s1.toCharArray(),s2.toCharArray());
        // int len = lcs2(s1.toCharArray(),s2.toCharArray(),0,0);
        // int len = lcs3(s1,s2,0,0);
        // Integer[][] dp = new Integer[s1.length()+1][s2.length()+1];
        //  int len = topDown2(s1,s2,s1.length(),s2.length(),dp);
        int len = bottomUp(s1,s2);
        System.out.println(len);
    }
}
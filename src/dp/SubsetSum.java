package dp;

public class SubsetSum {
    public boolean isSubSetSum(int[] arry, int sum) {
        boolean[][] dp = new boolean[arry.length +1][sum+1];

        for(int i =0; i<dp.length; i++){
            dp[i][0] = true;
        }
        for(int j=1; j<= sum; j++ ) {
            dp[0][j] = false;
        }

        for(int i=1; i<= arry.length; i++){
            for(int j =1; j<=sum; j++){
                if(arry[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = (dp[i-1][j] || dp[i-1][j-arry[i-1]] );
                }
            }
        }
        return dp[arry.length][sum];
    }

    public static void main(String[] args) {
        int[] arry = {2,2,3};
        SubsetSum subsetSum = new SubsetSum();
        System.out.println(subsetSum.isSubSetSum(arry, 7));
    }
}

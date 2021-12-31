package dp;

public class KSets {

        public int getKPartitions(int n, int k){
            if(k ==1) return 1;
            if(n==k) return 1;
            return k * getKPartitions(n-1, k) + getKPartitions(n-1, k-1);

        }

        public int getKPartitionsDP(int n, int k){
            int[][] dp = new int[n+1][k+1];
            for(int i =1; i<=n; i++){
                for(int j=1; j <=i && j<=k; j++){
                    if(j==1 || (i ==j))
                        dp[i][j] = 1;
                    else {
                        dp[i][j] = j * dp[i-1][j] + dp[i-1][j-1];
                    }
                }
            }
            return dp[n][k];
        }

    public static void main(String[] args) {
            KSets kSets = new KSets();
        System.out.println(kSets.getKPartitions(3,2));
        System.out.println(kSets.getKPartitionsDP(3,2));
    }
}

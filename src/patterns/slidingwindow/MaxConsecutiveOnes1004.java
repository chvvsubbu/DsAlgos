package patterns.slidingwindow;

public class MaxConsecutiveOnes1004 {

    public static int longestOnes(int[] A, int K) {
        int windowStart = 0;
        int currentZeros=0;
        int output = Integer.MIN_VALUE;

        for (int windowEnd = 0; windowEnd <A.length; windowEnd++){
            if(A[windowEnd] ==0) currentZeros++;
            while (currentZeros > K){
                if(A[windowStart] == 0) currentZeros--;
                windowStart++;
            }
            output = Math.max(output, windowEnd-windowStart+1);
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[] {1,1,1,0,0,0,1,1,1,1,0},2));
    }
}

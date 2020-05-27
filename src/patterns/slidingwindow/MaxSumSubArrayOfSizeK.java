package patterns.slidingwindow;

public class MaxSumSubArrayOfSizeK {
    public static int findMaxSumSubArray(int K, int[] arr){

        int windowEnd=0, windowStart=0;
        int currentSum=0, maxSum=0;

        for(windowEnd = 0 ; windowEnd < arr.length; windowEnd++){
            currentSum += arr[windowEnd];
            if(windowEnd >= K-1){
                maxSum = Math.max(maxSum, currentSum);
                currentSum -= arr[windowStart];
                windowStart++;

            }
        }
        return maxSum;
    }

    public static void main(String[] args) {

        int maxSumSubArray = findMaxSumSubArray(2, new int[]{2, 3, 4, 1, 5});
        System.out.println("maxSumSubArray: "+maxSumSubArray);
    }
}

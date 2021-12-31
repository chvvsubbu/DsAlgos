package patterns.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;

public class AverageOfSubarrayOfSizeK {

    public static double[]  findAverages(int K, int[] arr ){
        double[] result = new double[arr.length - K + 1];
        int windowStart = 0;
        int windowEnd = 0;

        double currentWindowSum=0;
        for( windowEnd = 0 ; windowEnd <arr.length ; windowEnd++){
            currentWindowSum +=arr[windowEnd];
            if(windowEnd >= K-1){
                result[windowStart] = currentWindowSum/ K;
                currentWindowSum -=arr[windowStart];
                windowStart++;
            }
        }
        return  result;
    }

    public static double[] findAverages(int[] nums, int k){
        double[] result = new double[nums.length - k + 1];
        double currentWindowSum = 0;
        int windowStart = 0, windowEnd;

        for(windowEnd = 0; windowEnd < nums.length; windowEnd++ ){
            currentWindowSum +=nums[windowEnd];
            if(windowEnd >= k - 1){
                result[ windowEnd - k + 1] =  currentWindowSum /  k;
                currentWindowSum -= nums[windowStart++];
            }
        }
        return result;
    }


    public static void main(String[] args) {
        double[] averageResult = findAverages(5,  new  int[]{1, 3, 2, 6, -1, 4, 1, 8, 2});
        System.out.println("result: "+ Arrays.toString(averageResult));
        averageResult = findAverages  (new  int[]{1, 3, 2, 6, -1, 4, 1, 8, 2}, 5);
        System.out.println("result: "+ Arrays.toString(averageResult));
    }

}

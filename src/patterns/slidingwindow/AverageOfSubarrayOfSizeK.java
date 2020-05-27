package patterns.slidingwindow;

import java.util.Arrays;

public class AverageOfSubarrayOfSizeK {

    public static double[]  findAverages(int K, int[] arr ){
        double[] result = new double[arr.length - K + 1];
        int windowStart = 0;
        int windowEnd = 0;

        int currentWindowSum=0;
        for( windowEnd = 0; windowEnd <arr.length; windowEnd++){
            currentWindowSum +=arr[windowEnd];
            if(windowEnd >= K-1){
                result[windowStart] = currentWindowSum/(float) K;
                currentWindowSum -=arr[windowStart];
                windowStart++;
            }
        }
        return  result;
    }


    public static void main(String[] args) {
        double[] averageResult = findAverages(5,  new  int[]{1, 3, 2, 6, -1, 4, 1, 8, 2});
        System.out.println("result: "+ Arrays.toString(averageResult));
    }

}

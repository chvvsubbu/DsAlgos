package patterns.slidingwindow;

public class MinSizeSubArraySum {
    public static int findMinSubArray(int K, int[] arr){
        int windowStart=0, windowEnd=0, currentSum =0;
        int minSubArryLength = Integer.MAX_VALUE;

        while(windowEnd <arr.length){
            currentSum +=arr[windowEnd++];
            while (currentSum >= K ){
                minSubArryLength = Math.min(minSubArryLength, windowEnd-windowStart+1);
                currentSum -=arr[windowStart];
                windowStart++;
            }
        }
        return  minSubArryLength == Integer.MAX_VALUE? 0 : minSubArryLength;
    }

    public static int findMinSubArray( int[] arr, int K){

        int windowStart=0, windowEnd=0, currentSum =0;
        int minSubArryLength = Integer.MAX_VALUE;

        while (windowEnd < arr.length ) {
            currentSum += arr[windowEnd++];
            while (currentSum >= K) {
                minSubArryLength = Math.min(minSubArryLength, windowEnd - windowStart +1);
                currentSum -= arr[windowStart++];
            }
        }
        return minSubArryLength == Integer.MAX_VALUE? 0 : minSubArryLength;

    }

    public static void main(String[] args) {
        int minSubArryLength = findMinSubArray(7, new int[] {2, 1, 5, 2, 3, 2});
        System.out.println("minSubArryLength: "+minSubArryLength);
        minSubArryLength = findMinSubArray( new int[] {8,8,8} , 7);
        System.out.println("minSubArryLength: "+minSubArryLength);
    }
}

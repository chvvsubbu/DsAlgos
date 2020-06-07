package patterns.slidingwindow;

public class ReplacingOnes {

    public  static int findLength(int[] arr, int k){

        int windowStart = 0, windowEnd = 0, onesCount = 0, maxLength =0;
        for(windowEnd = 0; windowEnd < arr.length; windowEnd++){
            if(arr[windowEnd] == 1){
                onesCount++;
            }

            if (windowEnd - windowStart +1 - onesCount > k){
                if(arr[windowStart] == 1){
                    onesCount--;
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart +1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(findLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
        System.out.println(findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));

    }
}

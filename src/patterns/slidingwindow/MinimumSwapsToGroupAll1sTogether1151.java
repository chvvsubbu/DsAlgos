package patterns.slidingwindow;

import java.util.Arrays;

public class MinimumSwapsToGroupAll1sTogether1151 {

    public static int minSwaps(int[] data) {
        int k = Arrays.stream(data).filter(n -> n%2 == 1).sum();
        if(k <=1) return 0;
        int currentWindow, minSwaps = Integer.MAX_VALUE, windowZeros=0;

        for(currentWindow =0 ; currentWindow < data.length ; currentWindow ++){
            if(data[currentWindow] ==0) windowZeros++;

            if(currentWindow >=k-1){
                minSwaps = Math.min(minSwaps, windowZeros );
                if(data[currentWindow-k+1] ==0) windowZeros--;
            }

        }
        return minSwaps;
    }

    public static void main(String[] args) {
        System.out.println(minSwaps(new int[] {0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,1,0,1,1,0,0,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,1,1,1,1,0,0,1}));
    }
}

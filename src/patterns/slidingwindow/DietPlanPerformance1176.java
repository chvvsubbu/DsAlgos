package patterns.slidingwindow;

public class DietPlanPerformance1176 {
    public static int dietPlanPerformance(int[] arr, int range, int lowerLimit, int upperLimit){
        int windowEnd = 0, totalPoint = 0, currentWindowCalories =0;

        for(windowEnd = 0; windowEnd < arr.length; windowEnd ++){
            currentWindowCalories += arr[windowEnd];
            if(windowEnd >= range-1){
                if(currentWindowCalories > upperLimit) totalPoint++;
                if(currentWindowCalories < lowerLimit) totalPoint--;
                currentWindowCalories -= arr[windowEnd-range+1];
            }
        }
        return totalPoint;
    }

    public static void main(String[] args) {
        System.out.println(dietPlanPerformance(new int[]{1,2,3,4,5},1,3,3));
        System.out.println(dietPlanPerformance(new int[]{3,2},2,0,1));
        System.out.println(dietPlanPerformance(new int[]{6,5,0,0},2,1,5));
    }
}

package dp;

public class LIS {
    public int findLISLength(int[] nums) {
        return findLISLengthRecurssively(nums, 0, -1);
    }

    private int findLISLengthRecurssively(int[] nums, int currentIndex, int previousIndex) {

        if(currentIndex == nums.length) return  0;
        int c1= 0;
        if(previousIndex== -1 || nums[currentIndex] >nums[previousIndex])
            c1 = 1+ findLISLengthRecurssively(nums, currentIndex+1, currentIndex);
        int c2 = findLISLengthRecurssively(nums, currentIndex+1, previousIndex);

        return Math.max(c1,c2);
    }


    public static void main(String[] args) {
        LIS lis = new LIS();

        System.out.println(lis.findLISLength(new int[] {4,2,3,6,10,1,12}));
        System.out.println(lis.findLISLength(new int[] {-4, 10, 3, 7, 15}));
    }


}

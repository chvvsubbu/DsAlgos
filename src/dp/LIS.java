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

    private  int fingLISLengthDP(int[] num){

        int[] lis = new int[num.length];
        for (int i = 0; i < lis.length; i++) {
            lis[i] = 1;
        }

        for (int i = 1; i < num.length; i++) {
            for (int j = 0; j < i; j++) {
                if(num[i] >= num[j] && (lis[i]<=lis[j]))
                   lis[i] = lis[j]+1;
            }
        }
        return lis[lis.length-1];
    }


    public static void main(String[] args) {
        LIS lis = new LIS();

        System.out.println(lis.findLISLength(new int[] {4,2,3,6,10,1,12}));
        System.out.println(lis.fingLISLengthDP(new int[] {4,2,3,6,10,1,12}));
        System.out.println(lis.findLISLength(new int[] {-4, 10, 3, 7, 15}));
        System.out.println(lis.fingLISLengthDP(new int[] {-4, 10, 3, 7, 15}));
    }


}

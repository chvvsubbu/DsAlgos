package patterns.twopointer;

public class SortedArraySquares {
    public static int[] makeSquares(int[] arr) {
        int n = arr.length;
        int[] squares = new int[n];
        int left = 0, right = arr.length-1;
        int squareIndex = n-1;
        while (left <= right){
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];

            if(leftSquare >= rightSquare){
                squares[squareIndex--] = leftSquare;
                left++;
            }else {
                squares[squareIndex--] = rightSquare;
                right--;
            }
        }
        return squares;
    }

    public static void main(String[] args) {
        int[] result = SortedArraySquares.makeSquares(new int[] { -2, -1, 0, 2, 3 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();

        result = SortedArraySquares.makeSquares(new int[] { -3, -1, 0, 1, 2 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();


    }
}

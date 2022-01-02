package sort;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        print(arr);
        bubbleSort(arr);
        print(arr);
    }

    private static void bubbleSort(int[] arr) {

        for(int i = 0; i< arr.length; i++){
            boolean swapped = false;
            for(int j= 0; j< arr.length - i - 1 ; j++ ){
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                    swapped = true;
                }
            }
            if(swapped == false)
                break;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    private static void print(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

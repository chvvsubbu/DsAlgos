package sort;

public class MergeSort {

    public static void main(String[] args) {
        //int[] arr = {7,2,1,6,8,5,3,4};
        int[] arr = {8,7,6,5,4,3,2,1};
        mergeSort(arr);
        print(arr);

    }

    private static void mergeSort(int[] arr) {

        int n = arr.length;
        if(n < 2)
            return;

        int mid = n/2;
        int [] leftArray = new int[mid];
        int[] rightArray = new int[n - mid];
        for (int i = 0; i <= mid - 1; i++) {
            leftArray[i] =arr[i];
        }
        for (int i = mid; i <= n - 1; i++) {
            rightArray[i-mid] =arr[i];
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, arr);

    }

    private static void merge(int[] leftArray, int[] rightArray, int[] arr) {
        int llength = leftArray.length;
        int rlength = rightArray.length;
        int i =0,  j = 0, k =0;

        while (i< llength && j< rlength){
            if(leftArray[i] <= rightArray[j]){
                arr[k] = leftArray[i];
                i++;
                k++;
            }else{
                arr[k] = rightArray[j];
                j++;
                k++;
            }
        }

        while (i< llength) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rlength){
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

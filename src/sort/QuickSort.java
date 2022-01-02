package sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {7,2,1,6,8,5,3,4};
        quickSort(arr, 0, arr.length-1);
        print(arr);
    }

    public static void quickSort(int[] arr, int start, int end){
        if(start >= end)
            return;

        int pindex = partition(arr, start, end);
        quickSort(arr,start, pindex-1);
        quickSort(arr, pindex+1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int pindex = start -1;
        for (int i = start; i < end; i++) {
            if(arr[i] <= pivot){
                pindex++;
                swap(arr, i, pindex);
            }
        }
        swap(arr,pindex+1,end);
        return pindex +1;
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

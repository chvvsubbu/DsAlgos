package sort;

import static patterns.heaps.HeapSort.heapify;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {7,2,1,6,8,5,3,4};
        heapSort(arr);
        print(arr);

    }

    private static void heapSort(int[] arr) {
        int n = arr.length;
        buildHeap(arr);
        for (int i = n-1; i>= 0; i--) {
            swap(arr,0,i);
            heapify(arr,0,i);
        }
    }

    private static void buildHeap(int[] arr) {
        int n = arr.length;
        for (int i = n/2; i >=0 ; i--) {
            heapify(arr,i,n);
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

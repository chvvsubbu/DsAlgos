package sort;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {7,2,1,6,8,5,3,4};
        selectionSort(arr);
        print(arr);
    }

    private static void selectionSort(int[] arr) {
        for(int i = 0; i < arr.length; ++i) {
            int min_index = findMinIndex(arr, i);
            if(i != min_index)
                swap(arr, i, min_index);
        }
    }

    private static int findMinIndex(int A[], int start) {
        int min_index = start;
        ++start;
        while(start < A.length) {
            if(A[start] < A[min_index])
                min_index = start;

            ++start;
        }

        return min_index;
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

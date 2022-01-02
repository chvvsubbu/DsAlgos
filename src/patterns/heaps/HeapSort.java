package patterns.heaps;

public class HeapSort {

    private static void heapSort(int[] arr) {
        int n = arr.length;
        buildHeap(arr);
        for (int i = n-1; i>= 0; i--) {
            swap(arr,0,i);
            heapify(arr,0,i);
        }
    }

    private static void buildHeap(int[] arr) {
        int n =arr.length;
        for (int i = n/2; i >=0 ; i--) {
            heapify(arr, i, n);
        }
    }

    public static void heapify(int[]arr, int i, int n){
        int left = 2*i + 1;
        int right = 2*i + 2;
        int largest =i;
        if(left < n && (arr[left] >arr[i])){
            largest = left;
        }
        if(right < n && (arr[right] >arr[largest])){
            largest = right;
        }
        if(largest != i){
            swap(arr, i, largest);
            heapify(arr, largest, n);
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {7,9,3,2,4,1,16,14,10,8};
        heapSort(arr);
        printArray(arr);

    }
}

package sort;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {1,6,2,5,4,3};
        insertionSort(arr);
        print(arr);
    }
    public static void insertionSort(int[] arr){
        if(arr == null || arr.length <=1)
            return;

        for(int i =1; i< arr.length; i++){
            int key= arr[i];
            int j=i-1;
            while( j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
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

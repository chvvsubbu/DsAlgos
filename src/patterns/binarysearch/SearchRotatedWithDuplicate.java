package patterns.binarysearch;

public class SearchRotatedWithDuplicate {
    public static int search(int[] arr, int key) {
        int start = 0, end = arr.length - 1;

        while (start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == key) return mid;

            if( (arr[start]== arr[mid]) && (arr[mid] == arr[end]) ){
                start++; end--;
            }else if(arr[start] < arr[mid]){
                if(key > arr[start] && key < arr[mid]){
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }else {
                if(key > arr[mid+1] && key < arr[end]){
                    start = mid + 1;
                }else {
                    end = mid - 1;
                }
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        System.out.println(SearchRotatedWithDuplicate.search(new int[] {3,3, 7, 3, 3, 3 }, 7));
    }
}

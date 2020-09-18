package patterns.binarysearch;

public class NextLetter {
    public static char searchNextLetter(char[] letters, char key){

        int start = 0, end = letters.length - 1;

        while (start <= end ){
            int mid = start +  (end-start) / 2;
            if(letters[mid] > key){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        System.out.println("start:" +start);
        return letters[start % letters.length];
    }

    public static void main(String[] args) {
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'f'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));

    }
}

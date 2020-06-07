package patterns.slidingwindow;

public class MaximumNumberofVowelsInaSubstringofGivenLength1456 {

    public static int maxVowels(String s, int k) {

        int maxOwels =0, windowEnd=0;
        int currentOwls =0;
        for(windowEnd = 0; windowEnd < s.length(); windowEnd++){
            if(isOwel (s.charAt(windowEnd)) ) currentOwls++;

            if(windowEnd >=k-1){
                maxOwels = Math.max(maxOwels, currentOwls );
                if (isOwel (s.charAt(windowEnd-k+1))) currentOwls--;
            }
        }
        return maxOwels;
    }

    public static boolean isOwel(char ch){
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef",3));
    }
}

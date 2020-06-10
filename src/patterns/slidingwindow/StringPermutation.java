package patterns.slidingwindow;

import java.util.Arrays;

public class StringPermutation {

    public static boolean findPermutation(String str, String pattern) {

        if(pattern.isEmpty() || (pattern.length() >str.length())) return false;

        int[] strHash = new int[26];
        int[] patternHash = new int[26];
        int windowRight =0;
        int sindex, pindex, left =0;
        while (windowRight < pattern.length()){
            pindex =pattern.charAt(windowRight)-'a';
            sindex = str.charAt(windowRight)-'a';
            patternHash[pindex]  =patternHash[pindex]+1;
            strHash[sindex] = strHash[sindex]+1;
            windowRight++;
        }
        windowRight--;

        while (windowRight <str.length()){
            if(Arrays.equals(strHash,patternHash)) return true;
            windowRight++;
            if(windowRight != str.length()){
                sindex = str.charAt(windowRight)-'a';
                strHash[sindex] ++;
                strHash[str.charAt(left)-'a'] --;
            }
            left++;

        }
        return  false;
    }

    public static void main(String[] args) {

        System.out.println("Permutation exist: " + StringPermutation.findPermutation("oidbcaf", "abc"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("odicf", "dc"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("bcdxabcdy", "bcdyabcdx"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("aaacb", "abc"));


    }
}

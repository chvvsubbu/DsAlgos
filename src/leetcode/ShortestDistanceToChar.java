package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class ShortestDistanceToChar {

    public static int[] shortestToChar(String s, char c) {

        int n = s.length();
        int[] dist  = new int[n];

        for(int i = 0; i< n; i++){
            if(s.charAt(i) ==c) continue;
            dist[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i< n-1; i++){
                if(dist[i] == Integer.MAX_VALUE) continue;
                else  dist[i+1] = Math.min(dist[i+1], dist[i]+1);
        }

        for(int i = n-1; i > 0; i--){
            dist[i-1] = Math.min(dist[i-1], dist[i]+1);
        }

        return  dist;
    }

    public static void main(String[] args) {

        System.out.println(ShortestDistanceToChar.shortestToChar("loveleetcode", 'e'));

    }

}

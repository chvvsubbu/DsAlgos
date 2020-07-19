package patterns.trees;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class OpenLock {

    public static int openLock(String[] deadEnds, String target) {
        if(target == null || target.length() ==0)
            return -1;
        HashSet<String> visited = new HashSet<>();
        HashSet<String> deadLocks = new HashSet<>(Arrays.asList(deadEnds));
        if(deadLocks.contains("0000") ) return -1;
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        int level =0;
        while (!queue.isEmpty() ){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if(curr.equals(target)){
                    return  level;
                }
                for (int j = 0; j < curr.length(); j++) {
                    int digit = curr.charAt(j)-'0';

                    int forward = (digit+1)%10;
                    String newState = curr.substring(0,j) + forward + curr.substring(j+1);
                    if (!visited.contains(newState) && !deadLocks.contains(newState)) {
                        queue.add(newState);
                        visited.add(newState);
                    }

                    int backward = (digit+9)%10;
                    String newState2 = curr.substring(0,j) + backward + curr.substring(j+1);
                    if (!visited.contains(newState2) && !deadLocks.contains(newState2)) {
                        queue.add(newState2);
                        visited.add(newState2);
                    }
                }
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args) {

        String[] deadEnds = new String[]{"0201","0101","0102","1212","2002"};
        System.out.println("min moves required: "+openLock(deadEnds,"0202"));
    }
}

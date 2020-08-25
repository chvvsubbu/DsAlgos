package patterns.heaps;

import java.util.HashMap;
import java.util.Map;

public class TaskScheduler {
    public static int scheduleTasks(char[] tasks, int k) {
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char ch : tasks){
            charFrequencyMap.put(ch, charFrequencyMap.getOrDefault(ch,0)+1);
        }
        return -1;
    }
    public static void main(String[] args) {
        char[] tasks = new char[] { 'a', 'a', 'a', 'b', 'c', 'c' };
        System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 2));

        tasks = new char[] { 'a', 'b', 'a' };
        System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 3));
    }

}

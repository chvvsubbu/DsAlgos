package patterns.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int distance(){
        return (x*x)+(y*y);
    }
}

public class KClosestPointsToOrigin {

     public static List<Point> findClosestPoints(Point[] points, int K){
         PriorityQueue<Point> maxHeap = new PriorityQueue<>((p1, p2)-> p2.distance()-p1.distance());
         for (int i = 0; i < K; i++) {
             maxHeap.add(points[i]);
         }
         for (int i = K; i < points.length; i++) {
             if(points[i].distance() < maxHeap.peek().distance()){
                 maxHeap.poll();
                 maxHeap.add(points[i]);
             }
         }
         return new ArrayList<>(maxHeap);
     }

    public static void main(String[] args) {
        Point[] points = new Point[] { new Point(1, 3), new Point(3, 4), new Point(2, -1) };
        List<Point> result = KClosestPointsToOrigin.findClosestPoints(points, 2);
        System.out.print("Here are the k points closest the origin: ");
        for (Point p : result)
            System.out.print("[" + p.x + " , " + p.y + "] ");
    }

    public int distance(int[] point){
        return (point[0]* point[0] +  point[1]* point[1]);
    }


}

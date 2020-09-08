package lambdas;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Java8Demo {

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1,2,3,4,5,6);
        System.out.println();

        // External Iterations
        //Internal Iterations
        //values.forEach(i->System.out.print(i+" "));
        //values.forEach(System.out::print);
        System.out.println(values.stream().map(i-> i*2).reduce(0, (c,e)-> c+e));


    }
}

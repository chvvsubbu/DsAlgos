package lambdas;

public interface Actor {

    void act();
    void speak();
    default void comedy(){
        System.out.println("I cna make people laugh");
    }
}

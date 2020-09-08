package lambdas;

public class Villan implements Actor {
    @Override
    public void act() {
        System.out.println("I can act");
    }

    @Override
    public void speak() {
        System.out.println("I can act");
    }

    public void rude(){
        System.out.println("I an rude");
    }
}

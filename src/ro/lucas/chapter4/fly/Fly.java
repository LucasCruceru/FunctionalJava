package ro.lucas.chapter4.fly;

public interface Fly {
    default void takeOff(){ System.out.println("Fly::takeOff");}
    default void land(){ System.out.println("Fly::land");}
    default void turn(){ System.out.println("Fly::turn");}
    default void cruise(){ System.out.println("Fly::cruise");}
}

interface FastFly extends Fly{
    default void takeOff(){ System.out.println("FastFly::takeOff");}
}

interface Sail{
    default void cruise() { System.out.println("Sail::cruise"); }
    default void turn() { System.out.println("Sail::turn"); }
}

class Vehicle {
    void turn() { System.out.println("Vehicle::turn"); }
}